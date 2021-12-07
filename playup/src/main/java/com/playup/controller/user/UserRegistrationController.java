// Author: Mugdha Anil Agharkar

package com.playup.controller.user;

import com.playup.model.user.IUser;
import com.playup.model.user.User;
import com.playup.model.user.UserFactory;
import com.playup.model.user.UserObjectFactory;
import com.playup.service.email.IEmailSenderService;
import com.playup.dao.user.IOneTimePasswordDao;
import com.playup.model.user.*;
import com.playup.service.user.IOneTimePasswordService;
import com.playup.service.user.IUserRegistrationService;
import com.playup.service.user.PasswordValidationService;
import com.playup.service.user.UserProfileServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;

@Controller
public class UserRegistrationController {

    IUserRegistrationService userRegistrationService;
    IOneTimePasswordService oneTimePasswordService;
    IOneTimePasswordDao oneTimePasswordDao;

    @Autowired
    private IEmailSenderService emailService;

    public UserRegistrationController() {
        this.oneTimePasswordService = UserProfileServiceFactory.instance().oneTimePasswordService();
        this.userRegistrationService = UserProfileServiceFactory.instance().userRegistrationService();
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", UserFactory.userObject(new UserObjectFactory()));
        return "registration";
    }

    @GetMapping("/otp")
    public String getOtp(Model model) {
        model.addAttribute("oneTimePassword", new OneTimePassword());
        return "otp";
    }

    @RequestMapping(value = "/otp", method = { RequestMethod.POST, RequestMethod.GET })
    public String verifyOtp(@ModelAttribute OneTimePassword oneTimePassword, @RequestParam String emailId,
                            @RequestParam String password, @RequestParam String userName,
                            @RequestParam String contactNumber, @RequestParam String city,
                            Model model) {
        IUser user = UserFactory.userObject(new UserObjectFactory());
        user.setUserName(userName);
        user.setPassword(password);
        user.setContactNumber(contactNumber);
        user.setCity(city);
        user.setEmail(emailId);
        String response = null;
        try {
            response = oneTimePasswordService.verifyOTP(emailId, oneTimePassword.getOneTimePassword());
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        boolean success = false;
        try {
            success = userRegistrationService.registerNewUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addAttribute("response", response);
        if(response.equals("email_verified") && success) {
            return "venues";
        }

        return "otp";
    }

    @PostMapping("/registration")
    public String registerNewUser(@ModelAttribute User user, Model model) throws SQLException {
        PasswordValidationService passwordValidationService = new PasswordValidationService();
        System.out.println(user.getPassword());
        System.out.println(model.getAttribute("user"));
        boolean isPasswordValid = passwordValidationService.isPasswordValid(user.getPassword());
        boolean isRegisteredUser = userRegistrationService.isUserAlreadyRegistered(user);

        boolean isOtpValid = false;
        if(!isRegisteredUser) {
            if (!isPasswordValid) {
                model.addAttribute("user", UserFactory.userObject(new UserObjectFactory()));
                model.addAttribute("policy", passwordValidationService);
                model.addAttribute("error", "Your new password does not satisfy password policy.");
                return "registration";

            } else {
                model.addAttribute("success", "Send OTP");
                String response = oneTimePasswordService.sendOTP(user.getEmail());
                String otpSubject = "Email Verification - PlayUP";
                String otpBody = "Your 6-digit OTP for Email Verification is - \n" + response + "\n" +
                        "It is valid for 15 minutes.";
                emailService.sendEmail(user.getEmail(), otpBody, otpSubject);
                model.addAttribute("emailId", user.getEmail());
                model.addAttribute("userName", user.getUserName());
                model.addAttribute("contactNumber", user.getContactNumber());
                model.addAttribute("password", user.getPassword());
                model.addAttribute("city", user.getCity());
                model.addAttribute("oneTimePassword", new OneTimePassword());
                return "otp";
            }
        }
       else {
            return "user_exists";
        }
    }
}
