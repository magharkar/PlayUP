
package com.playup.playup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PlayupController {
    @GetMapping("/")
    public String BaseCode(){
        return ("index");
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("registration", new Registration());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute Registration registration, Model model) {
        model.addAttribute("registration", registration);
        System.out.println(registration);
        return "registration";
    }
}
