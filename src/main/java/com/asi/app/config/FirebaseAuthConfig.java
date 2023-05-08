package com.asi.app.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
public class FirebaseAuthConfig {
    @Value("classpath:service-account.json")
    Resource serviceAccount;

    @Bean
    FirebaseAuth firebaseAuth() throws IOException {
     var options = FirebaseOptions.builder()
             .setCredentials(GoogleCredentials.fromStream(serviceAccount.getInputStream()))
             .build();

     FirebaseApp firebaseApp = null;
     if(FirebaseApp.getApps().isEmpty()){
         //Checking if App is empty then
         firebaseApp = FirebaseApp.initializeApp(options);
     } else {
         firebaseApp = FirebaseApp.getApps().get(0);
     }

     return FirebaseAuth.getInstance(firebaseApp);
    }
}
