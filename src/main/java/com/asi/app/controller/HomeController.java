package com.asi.app.controller;

import com.asi.app.entity.User;


import com.asi.app.security.IAuthenticationFacade;
import com.asi.app.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
public class HomeController {

    @Autowired
    private UserManagementService userManagementService;
    @Autowired
    private IAuthenticationFacade authenticationFacade;
    @GetMapping(path = "/test")
    public String currentUserName() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();
    }

    @PostMapping("/signUp")
    public String register(@RequestBody User user){
            return userManagementService.register(user);
    }

    @PostMapping("/signIn")
    public String login(@RequestBody User user){
      return userManagementService.login(user);
    }

}
