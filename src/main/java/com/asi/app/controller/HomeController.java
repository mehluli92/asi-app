package com.asi.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {
    @GetMapping("/test")
    public String home(Principal principal){
        return "Hello, " + principal.getName();
    }
}
