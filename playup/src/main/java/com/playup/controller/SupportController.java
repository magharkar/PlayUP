package com.playup.controller;

import com.playup.model.SupportModel;
import com.playup.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SupportController {



    @Autowired
    private EmailSenderService emailService;

    @GetMapping("/Support")
    public String SupportMethod() {
//       emailService.sendEmail("shivdesai612@gmail.com","This is testing mail","Testing Subject");
        return "support";
    }

//    @RequestMapping("/Support1")
//    public String Support() {
//        //   model.addAttribute("support", new SupportModel());
//        //   service.sendEmail("shivdesai612@gmail.com","This is testing mail","Testing Subject");
//        return "registration";
//    }


}
