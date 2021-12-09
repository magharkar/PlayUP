package com.playup.controller.user;

import com.playup.constants.ApplicationConstants;
import com.playup.model.user.IUser;
import com.playup.model.user.User;
import com.playup.model.user.UserFactory;
import com.playup.model.user.UserObjectFactory;
import com.playup.service.email.IEmailSenderService;
import com.playup.dao.user.IOneTimePasswordDao;
import com.playup.model.user.*;
import com.playup.service.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * @author Mugdha Anil Agharkar
 */

@Controller
public class UserRegistrationController {
    IUserRegistrationService userRegistrationService;

    IOneTimePasswordService oneTimePasswordService;

    IOneTimePasswordDao oneTimePasswordDao;

    @Autowired
    private IEmailSenderService emailService;

    @Autowired
    private IPasswordValidationService passwordValidationService;

    public UserRegistrationController() {
        this.oneTimePasswordService = UserProfileServiceFactory.instance().oneTimePasswordService();
        this.userRegistrationService = UserProfileServiceFactory.instance().userRegistrationService();
    }

    @RequestMapping(ApplicationConstants.LOGOUT_URL)
    public String defectDetails() {
        return ApplicationConstants.LOGOUT_HTML;
    }

    @GetMapping(ApplicationConstants.REGISTRATION_URL)
    public String registrationForm(Model model) {
        model.addAttribute(ApplicationConstants.USER_OBJECT, UserFactory.userObject(new UserObjectFactory()));
        return ApplicationConstants.REGISTRATION_HTML;
    }

    @GetMapping(ApplicationConstants.OTP_URL)
    public String getOtp(Model model) {
        model.addAttribute(ApplicationConstants.OTP_OBJECT, new OneTimePassword());
        return ApplicationConstants.OTP_HTML;
    }

    @RequestMapping(value = ApplicationConstants.OTP_URL, method = { RequestMethod.POST, RequestMethod.GET })
    public String verifyOtp(@ModelAttribute OneTimePassword oneTimePassword, @RequestParam String emailId,
                            @RequestParam String password, @RequestParam String userName,
                            @RequestParam String contactNumber, @RequestParam String city,
                            @RequestParam String sport, Model model) {
        IUser user = UserFactory.userObject(new UserObjectFactory());
        user.setUserName(userName);
        user.setPassword(password);
        user.setContactNumber(contactNumber);
        user.setCity(city);
        user.setEmail(emailId);
        user.setSport(sport);
        String response = null;
        response = oneTimePasswordService.verifyOTP(emailId, oneTimePassword.getOneTimePassword());
        boolean success = false;
        success = userRegistrationService.registerNewUser(user);
        model.addAttribute(ApplicationConstants.RESPONSE_TEXT, response);
        if(response.equals(ApplicationConstants.EMAIL_VERIFIED) && success) {
            return ApplicationConstants.REDIRECT_VENUE_HTML;
        }

        return ApplicationConstants.OTP_HTML;
    }

    @PostMapping(ApplicationConstants.REGISTRATION_URL)
    public String registerNewUser(@ModelAttribute User user, Model model) throws SQLException {
        boolean isPasswordValid = passwordValidationService.isPasswordValid(user.getPassword(), user.getConfirmPassword());
        boolean isRegisteredUser = userRegistrationService.isUserAlreadyRegistered(user);

        boolean isOtpValid = false;
        if(!isRegisteredUser) {
            if (!isPasswordValid) {
                model.addAttribute(ApplicationConstants.USER_OBJECT, UserFactory.userObject(new UserObjectFactory()));
                model.addAttribute(ApplicationConstants.ERROR, ApplicationConstants.PASSWORD_POLICY_ERROR);
                return ApplicationConstants.REGISTRATION_HTML;

            } else {
                String response = oneTimePasswordService.sendOTP(user.getEmail());
                String otpSubject = ApplicationConstants.EMAIL_VERIFICATION_SUBJECT;
                String otpBody = ApplicationConstants.EMAIL_VERIFICATION_BODY + response + "\n" +
                        ApplicationConstants.EMAIL_VERIFICATION_VALIDITY;
                emailService.sendEmail(user.getEmail(), otpBody, otpSubject);
                model.addAttribute(ApplicationConstants.EMAIL_ID_ATTRIBUTE, user.getEmail());
                model.addAttribute(ApplicationConstants.USERNAME_ATTRIBUTE, user.getUserName());
                model.addAttribute(ApplicationConstants.CONTACT_ATTRIBUTE, user.getContactNumber());
                model.addAttribute(ApplicationConstants.PASSWORD_ATTRIBUTE, user.getPassword());
                model.addAttribute(ApplicationConstants.CITY, user.getCity());
                model.addAttribute(ApplicationConstants.OTP_OBJECT, new OneTimePassword());
                model.addAttribute(ApplicationConstants.SPORT, user.getSport());
                return ApplicationConstants.OTP_HTML;
            }
        }
       else {
            return ApplicationConstants.USER_EXISTS;
        }
    }
}
