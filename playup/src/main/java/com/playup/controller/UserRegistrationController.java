package com.playup.controller;

import com.playup.model.User;
import com.playup.model.UserFactory;
import com.playup.model.UserObjectFactory;
import com.playup.service.*;
import com.playup.service.email.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

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

    @PostMapping("/registration")
    public String registerNewUser(@ModelAttribute User user, Model model) throws SQLException {
        PasswordValidationService passwordValidationService = new PasswordValidationService();
        System.out.println(user.getPassword());
        System.out.println(model.getAttribute("user"));
        boolean isPasswordValid = passwordValidationService.isPasswordValid(user.getPassword());
        boolean isOtpValid = false;
        System.out.println("THIS?????");
        if (!isPasswordValid) {
            model.addAttribute("user", UserFactory.userObject(new UserObjectFactory()));
            model.addAttribute("policy", passwordValidationService);
            model.addAttribute("error", "Your new password does not satisfy password policy.");
            return "registration";

        } else {
            emailService.sendEmail("mugdha.agharkar@gmail.com", "sdasad", "test");
                }
        boolean isRegisteredUser = userRegistrationService.isUserAlreadyRegistered(user);
        if (!isRegisteredUser) {
            model.addAttribute("success", "Send OTP");
            String response = oneTimePasswordService.sendOTP(user.getEmail());
            return "otp";
        } else {
            return "user_exists";
        }
    }
}
