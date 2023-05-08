package com.asi.app.controller;

import com.asi.app.entity.User;
import com.asi.app.repository.UserRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/")
public class AuthController {
    @Autowired
    UserRepository userRepository;
    @PostMapping("/register")
    public String register(@RequestBody User user) throws InterruptedException, ExecutionException{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Firestore firestore = FirestoreClient.getFirestore();
        String uid = authentication.getName();

        ApiFuture<WriteResult> collectionApiFuture = firestore.collection("users")
                .document(user.getEmail())
               // .document(user.getPassword())
                .set(user);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    @GetMapping("/firbaseUser")
    public User getUser(@RequestParam String id) throws InterruptedException, ExecutionException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("email").document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot documentSnapshot = future.get();
        User user;
        if(documentSnapshot.exists()){
            user = documentSnapshot.toObject(User.class);
            return user;
        }
        return null;
    }
}
