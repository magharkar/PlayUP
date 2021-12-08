package com.playup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayupController {
    @GetMapping("/")
    public String BaseCode(){
        return ("index");
    }
}
