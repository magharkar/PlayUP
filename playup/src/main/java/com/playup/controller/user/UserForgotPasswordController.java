package com.playup.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserForgotPasswordController {

    @GetMapping("/forgot_password")
    public String getLogin(Model model) {
        System.out.println("Reaching here");
       // model.addAttribute("user", SupportFactory.userObject(new SupportObjectFactory()));
        return "forgot_password";
    }
}
