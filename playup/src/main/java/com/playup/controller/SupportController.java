/**
 * @author Shiv Gaurang Desai
 */
package com.playup.controller;

import com.playup.constants.ApplicationConstants;
import com.playup.model.SupportModel;
import com.playup.service.EmailSenderService;
import com.playup.service.SupportService;
import com.playup.service.TicketGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SupportController {


    @Autowired
    private SupportService supportService;

    @Autowired
    private TicketGeneratorService ticketGeneratorService;

    @Autowired
    private EmailSenderService emailService;

    @GetMapping("/support")
    public String SupportMethod(Model model) {
    model.addAttribute("support",new SupportModel());
    return "support";
    }

    @PostMapping("/support")
    public String generateSupportRequest(@ModelAttribute SupportModel supportModel, Model model){
       supportModel.setTicketNumber(TicketGeneratorService.getInstance().generateTicketNumber(ApplicationConstants.minimumSupportTicketNumber,ApplicationConstants.maximumSupportTicketNumber));
        boolean isRequestGenerated = supportService.generateSupportRequest(supportModel);
        if (isRequestGenerated) {
            emailService.sendEmail(supportModel.getEmail(), ApplicationConstants.supportEmailBody, ApplicationConstants.supportSubject+supportModel.getTicketNumber());
            return "support_confirmation";
        } else {

        }
        return "support_confirmation";
    }

}
