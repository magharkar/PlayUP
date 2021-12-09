/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.controller.user;

import com.playup.constants.ApplicationConstants;
import com.playup.model.user.OneTimePassword;
import com.playup.service.email.IEmailSenderService;
import com.playup.service.user.IOneTimePasswordService;
import com.playup.service.user.UserProfileServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

@Controller
public class UserForgotPasswordController {
    @Autowired
    private IEmailSenderService emailService;

    IOneTimePasswordService oneTimePasswordService;

    public UserForgotPasswordController () {
        this.oneTimePasswordService = UserProfileServiceFactory.instance().oneTimePasswordService();
    }

    @GetMapping(ApplicationConstants.FORGOT_PASSWORD_URL)
    public String getLogin(Model model) {
        return ApplicationConstants.FORGOT_PASSWORD_HTML;
    }

    @PostMapping(ApplicationConstants.FORGOT_PASSWORD_URL)
    public String redirectToOtp(@RequestParam String emailId, Model model) {
        String response = null;
        try {
            response = oneTimePasswordService.sendOTP(emailId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String otpSubject = ApplicationConstants.EMAIL_VERIFICATION_SUBJECT;
        String otpBody = ApplicationConstants.EMAIL_VERIFICATION_BODY + response + "\n" +
                ApplicationConstants.EMAIL_VERIFICATION_VALIDITY;
        emailService.sendEmail(emailId, otpBody, otpSubject);
        model.addAttribute(ApplicationConstants.EMAIL_ID_ATTRIBUTE, emailId);
        model.addAttribute(ApplicationConstants.OTP_ATTRIBUTE, new OneTimePassword());
        return ApplicationConstants.FORGOT_PASSWORD_OTP_HTML;
    }

    @GetMapping(ApplicationConstants.FORGOT_PASSWORD_OTP_URL)
    public String getOtpLogin( Model model) {
         model.addAttribute(ApplicationConstants.OTP_ATTRIBUTE, new OneTimePassword());
        return ApplicationConstants.FORGOT_PASSWORD_OTP_HTML;
    }

    @RequestMapping(value = ApplicationConstants.FORGOT_PASSWORD_OTP_URL, method = { RequestMethod.POST, RequestMethod.GET })
    public String setNewPassword(@RequestParam String emailId, @ModelAttribute OneTimePassword oneTimePassword,
                                 @RequestParam String password, Model model) {
        String response = null;
        response = oneTimePasswordService.verifyOTPForPasswordReset(emailId, oneTimePassword.getOneTimePassword(), password);
        model.addAttribute(ApplicationConstants.RESPONSE_TEXT, response);
        if(response.equals(ApplicationConstants.PASSWORD_UPDATE_SUCCESSFUL)) {
            return ApplicationConstants.REDIRECT_VENUE_HTML;
        }
        return ApplicationConstants.FORGOT_PASSWORD_OTP_HTML;
    }
}
