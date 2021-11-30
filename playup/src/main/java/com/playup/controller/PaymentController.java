package com.playup.controller;

import com.playup.constants.ApplicationConstants;
import com.playup.model.SupportModel;
import com.playup.service.TicketGeneratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController {

    @GetMapping("/Payment")
    public ModelAndView paymentMethod() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("payment");
        return mv;
    }

    @PostMapping("/support")
    public String generateSupportRequest(@ModelAttribute SupportModel supportModel, Model model) {


        

        return "payment";
    }

}
