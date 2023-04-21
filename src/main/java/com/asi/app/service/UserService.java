package com.asi.app.service;

import com.asi.app.entity.Contact;
import com.asi.app.entity.User;
import com.asi.app.repository.ContactRepository;
import com.asi.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private ContactRepository contactRepository;

    public User saveUser(User user){
        user.setContact(user.getContact());
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public String deleteUser(Long id){
        Long userId = id;
        userRepository.deleteById(id);
        return "User deleted successfully"+userId;
    }

    public User updateUser(User user){
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser = user;
        existingUser.setContact(user.getContact());
        return userRepository.save(existingUser);
    }

//    public User enableDisable(User user){
//        User existingUser = userRepository.findById(user.getId()).orElse(null);
//        String message;
//        if (existingUser.getDisabled() == true)
//        {
//            existingUser.setDisabled(false);
//            message = "User"+existingUser.getFirstName()+"Has been disabled";
//        } else {
//            existingUser.setDisabled(true);
//            message = "User"+existingUser.getFirstName()+"Has been restored";
//        }
//        return existingUser;
//    }

}
