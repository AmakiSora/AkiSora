package com.cosmos.controller;

import com.cosmos.service.AkiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AkiUserController {
    @Autowired
    private AkiUserService akiUserService;
    @GetMapping("/focus/{id}")
    public String focus(@PathVariable String id){
        System.out.println(id);
        return akiUserService.focus(id);
    }
}
