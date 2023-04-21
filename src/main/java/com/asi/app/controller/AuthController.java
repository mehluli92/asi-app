package com.asi.app.controller;

import com.asi.app.entity.User;
import com.asi.app.service.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
    private final TokenService tokenService;
    public  AuthController(TokenService tokenService){
        this.tokenService = tokenService;
    }


    @PostMapping("/token")
    public String token(Authentication authentication){
        String token = tokenService.generateToken(authentication);
        return  token;
    }

    @PostMapping("/signIn")
    public String signIn(@RequestBody User user){
        try {
            String username = user.getFirstName();
            String password = user.getPassword();

        } catch (Exception e){

        }
        return " ";
    }
}
