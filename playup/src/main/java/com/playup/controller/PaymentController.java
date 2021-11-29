package com.playup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController {

    @GetMapping("/Payment")
    public ModelAndView paymentMethod() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("payment");
        return mv;
    }

}
