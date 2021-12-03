package com.playup.controller.user;

import com.playup.model.user.IUser;
import com.playup.model.user.User;
import com.playup.model.user.UserFactory;
import com.playup.model.user.UserObjectFactory;
import com.playup.service.*;
import com.playup.service.user.IOneTimePasswordService;
import com.playup.service.user.IUserRegistrationService;
import com.playup.service.user.PasswordValidationService;
import com.playup.service.user.UserProfileServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.text.ParseException;

@Controller
public class UserRegistrationController {

    IUserRegistrationService userRegistrationService;
    IOneTimePasswordService oneTimePasswordService;

    @Autowired
    private EmailSenderService emailService;

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
        model.addAttribute("user", UserFactory.userObject(new UserObjectFactory()));
        return "otp";
    }

    @PostMapping("otp")
    public String verifyOtp(@RequestParam String email, @RequestParam String otp, @RequestParam
            IUser user, Model model) throws SQLException, ParseException {

        String response = oneTimePasswordService.verifyOTP(email, otp);
        model.addAttribute("response", response);
        if(response.equals("email_verified")) {
            userRegistrationService.registerNewUser(user);
            return "support";
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
                return "otp";
            }
        }
       else {
            return "user_exists";
        }
    }
}
