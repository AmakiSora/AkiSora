package com.cosmos.modules.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("Timeout")
    public String Timeout(){
        return "connection timed out!";
    }

}
