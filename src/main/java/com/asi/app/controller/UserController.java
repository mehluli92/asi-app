package com.asi.app.controller;

import com.asi.app.entity.User;
import com.asi.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("addUserDetailsForFirstTime")
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/findUserById/{id}")
    public User findUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
