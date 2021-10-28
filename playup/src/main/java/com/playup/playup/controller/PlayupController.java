
package com.playup.playup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayupController {
    @GetMapping
    public String BaseCode(){
        return ("Hello World");
    }
}
