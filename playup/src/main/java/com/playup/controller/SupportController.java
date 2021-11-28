/**
 * @author Shiv Gaurang Desai
 */
package com.playup.controller;

import com.playup.constants.ApplicationConstants;
import com.playup.model.SupportModel;
import com.playup.service.EmailSenderService;
import com.playup.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class SupportController {


    @Autowired
    private SupportService supportService;

    @Autowired
    private EmailSenderService emailService;

    @GetMapping("/Support")
    public ModelAndView SupportMethod() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("support");
        return mv;
    }

    @RequestMapping(value = "/Support/SupportRequest", method = RequestMethod.POST)
    public String generateSupportRequest(@RequestBody Map<String, String> supportData){
        SupportModel supportModel = new SupportModel(supportData);
        boolean isRequestGenerated = supportService.generateSupportRequest(supportModel);
        if (isRequestGenerated) {
            emailService.sendEmail(supportModel.getEmail(), ApplicationConstants.supportEmailBody, ApplicationConstants.supportSubject+supportModel.getTicketNumber());
        } else {

        }
        return "support_confirmation";
    }

}
