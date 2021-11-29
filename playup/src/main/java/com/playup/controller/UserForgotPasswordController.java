package com.playup.controller;

import com.playup.model.UserFactory;
import com.playup.model.UserObjectFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserForgotPasswordController {

    @GetMapping("/forgot_password")
    public String getLogin(Model model) {
        System.out.println("Reaching here");
       // model.addAttribute("user", UserFactory.userObject(new UserObjectFactory()));
        return "forgot_password";
    }
}
