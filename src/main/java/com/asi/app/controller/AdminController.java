package com.asi.app.controller;

import com.asi.app.security.Permission;
import com.asi.app.service.UserManagementService;
import com.google.firebase.auth.FirebaseAuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserManagementService userManagementService;


    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @PostMapping(path = "/user-claims/{uid}")
    public void setUserClaims(
            @PathVariable String uid,
            @RequestBody List<Permission> requestedClaims
            ) throws FirebaseAuthException{
        userManagementService.setUserClaims(uid, requestedClaims);
    }
}
