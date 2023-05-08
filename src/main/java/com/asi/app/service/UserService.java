package com.asi.app.service;

import com.asi.app.entity.Contact;
import com.asi.app.entity.User;
import com.asi.app.repository.ContactRepository;
import com.asi.app.repository.UserRepository;
import com.asi.app.security.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private IAuthenticationFacade authenticationFacade;


    @Secured("ROLE_ANONYMOUS")
    public User saveUser(User user){
        Authentication authentication = authenticationFacade.getAuthentication();
        user.setFirebase_uid(authentication.getName());
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

}
