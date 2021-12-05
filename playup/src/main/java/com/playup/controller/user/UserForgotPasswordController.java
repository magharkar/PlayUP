package com.playup.controller.user;

import com.playup.model.user.OneTimePassword;
import com.playup.service.email.IEmailSender;
import com.playup.service.user.IOneTimePasswordService;
import com.playup.service.user.UserProfileServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;

@Controller
public class UserForgotPasswordController {

    @Autowired
    private IEmailSender emailService;

    IOneTimePasswordService oneTimePasswordService;

    public UserForgotPasswordController () {
        this.oneTimePasswordService = UserProfileServiceFactory.instance().oneTimePasswordService();
    }

    @GetMapping("/forgot_password")
    public String getLogin(Model model) {
        System.out.println("Reaching here");
       // model.addAttribute("user", SupportFactory.userObject(new SupportObjectFactory()));
        return "forgot_password";
    }

    @PostMapping("/forgot_password")
    public String redirectToOtp(@RequestParam String emailId, Model model) {
        String response = null;
        try {
            response = oneTimePasswordService.sendOTP(emailId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String otpSubject = "Email Verification - PlayUP";
        String otpBody = "Your 6-digit OTP for Email Verification is - \n" + response + "\n" +
                "It is valid for 15 minutes.";
        emailService.sendEmail(emailId, otpBody, otpSubject);
        model.addAttribute("emailId", emailId);
        model.addAttribute("oneTimePassword", new OneTimePassword());
        return "forgot_password_otp";
    }

    @GetMapping("/forgot_password_otp")
    public String getOtpLogin( Model model) {
        System.out.println("Reaching here");
         model.addAttribute("oneTimePassword", new OneTimePassword());
        return "forgot_password_otp";
    }

    @RequestMapping(value = "/forgot_password_otp", method = { RequestMethod.POST, RequestMethod.GET })
    public String setNewPassword(@RequestParam String emailId, @ModelAttribute OneTimePassword oneTimePassword,
                                 @RequestParam String password, Model model) {
        String response = null;
        try {
            response = oneTimePasswordService.verifyOTPForPasswordReset(emailId, oneTimePassword.getOneTimePassword(), password);
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        System.out.println(response);
        model.addAttribute("response", response);
        if(response.equals("password_update_successful")) {
            return "venueSorting";
        }
        return "support";
    }
}
