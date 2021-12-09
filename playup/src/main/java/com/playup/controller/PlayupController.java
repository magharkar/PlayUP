package com.playup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Mugdha Anil Agharkar
 */

@Controller
public class PlayupController {
    @GetMapping("/")
    public String BaseCode(){
        return ("index");
    }
}
