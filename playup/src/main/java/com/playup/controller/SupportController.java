package com.playup.controller;

import com.playup.constants.ApplicationConstants;
import com.playup.model.SupportModel;
import com.playup.service.EmailSenderService;
import com.playup.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class SupportController {


    @Autowired
    private SupportService supportService;

    @Autowired
    private EmailSenderService emailService;

    @GetMapping("/Support")
    public String SupportMethod() {
//       emailService.sendEmail("shivdesai612@gmail.com","This is testing mail","Testing Subject");
        return "support";
    }

    @GetMapping("/SupportRequest1")
    public String SupportMethod1() {
//       emailService.sendEmail("shivdesai612@gmail.com","This is testing mail","Testing Subject");
        return "support_confirmation";
    }

    @RequestMapping(value = "/Support/SupportRequest", method = RequestMethod.POST)
    public String getSearchResults(@RequestBody Map<String, String> supportData){
        System.out.println("This is the method");
        SupportModel supportModel = new SupportModel(supportService.generateTicketNumber(),supportData.get("name"),supportData.get("email"),supportData.get("venue"),supportData.get("description"));
        boolean isRequestGenerated = supportService.generateSupportRequest(supportModel);
        if (isRequestGenerated) {
            emailService.sendEmail(supportModel.getEmail(), ApplicationConstants.supportEmailBody, "Re: Received Complaint");
        } else {
            System.out.println("Not created");
        }
        return "support_confirmation";
    }


}
