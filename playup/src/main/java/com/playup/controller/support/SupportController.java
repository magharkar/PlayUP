/**
 * @author Shiv Gaurang Desai
 */
package com.playup.controller.support;

import com.playup.constants.ApplicationConstants;
import com.playup.model.support.SupportModel;
import com.playup.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class SupportController {

    @Autowired
    private ISupport supportService;

    @Autowired
    private IEmailSender emailService;

    @Autowired
    private  IEmailValidationService emailValid;

    @GetMapping("/support")
    public String SupportMethod(Model model) {
    model.addAttribute("support",new SupportModel());
    return "support";
    }

    @PostMapping("/support")
    public String generateSupportRequest(@ModelAttribute SupportModel supportModel, Model model) throws SQLException {

        if (emailValid.isEmailValid(supportModel.getEmail())) {
            supportModel.setTicketNumber(TicketGeneratorService.getInstance().generateTicketNumber(ApplicationConstants.minimumSupportTicketNumber, ApplicationConstants.maximumSupportTicketNumber));
            boolean isRequestGenerated = supportService.generateSupportRequest(supportModel);
            if (isRequestGenerated) {
                emailService.sendEmail(supportModel.getEmail(), ApplicationConstants.supportEmailBody, ApplicationConstants.supportSubject + supportModel.getTicketNumber());
                return "support_confirmation";
            }
        }
        else {
            model.addAttribute("support",supportModel);
            model.addAttribute("error","Email Id is not proper");
            return "support";
        }
        model.addAttribute("support",supportModel);
        model.addAttribute("error","Some Error Occured. Please try again later");
        return "support";
    }

}
