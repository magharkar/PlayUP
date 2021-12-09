/**
 * @author Shiv Gaurang Desai
 */
package com.playup.controller.support;

import com.playup.constants.ApplicationConstants;
import com.playup.model.support.SupportModel;
import com.playup.service.email.IEmailSenderService;
import com.playup.service.email.IEmailValidationService;
import com.playup.service.support.ISupportFactoryService;
import com.playup.service.support.ISupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SupportController {
    @Autowired
    private ISupportService supportService;

    @Autowired
    private IEmailSenderService emailService;

    @Autowired
    private IEmailValidationService emailValidationService;

    @Autowired
    private ISupportFactoryService supportFactoryService;

    @GetMapping("/support")
    public String support(Model model) {
        model.addAttribute(ApplicationConstants.SUPPORT_TEXT,supportFactoryService.getSupportModel());
        return ApplicationConstants.SUPPORT_TEXT;
    }

    @PostMapping("/support")
    public String generateSupportRequest(@ModelAttribute SupportModel supportModel,Model ui){
        if (emailValidationService.isEmailValid(supportModel.getEmail())) {
            boolean isRequestGenerated = supportService.generateSupportRequest(supportModel);
            if (isRequestGenerated) {
                emailService.sendEmail(supportModel.getEmail(), ApplicationConstants.SUPPORT_EMAIL_BODY, ApplicationConstants.SUPPORT_SUBJECT + supportModel.getTicketNumber());
                return ApplicationConstants.SUPPORT_CONFIRMATION_TEXT;
            }
        }
        else {
            ui.addAttribute(ApplicationConstants.SUPPORT_TEXT,supportModel);
            ui.addAttribute(ApplicationConstants.SUPPORT_ERROR,ApplicationConstants.EMAIL_ERROR_MESSAGE);
            return ApplicationConstants.SUPPORT_TEXT;
        }
        ui.addAttribute(ApplicationConstants.SUPPORT_TEXT,supportModel);
        ui.addAttribute(ApplicationConstants.SUPPORT_ERROR, ApplicationConstants.ERROR_MESSAGE);
        return ApplicationConstants.SUPPORT_TEXT;
    }
}
