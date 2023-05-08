package com.asi.app.config;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;


@Service
public class FirebaseInitializer {
    private static final Logger logger = LoggerFactory.getLogger(FirebaseInitializer.class);


    @PostConstruct
    public void onStart(){
        logger.info("Initializing a firebase app...");
        try{
               this.initializeFirebaseApp();
            logger.info("Success with firebase application initialization");
        }catch (IOException e){
            logger.error("Initializing firebase App", e);
        }
    }

    private void initializeFirebaseApp() throws IOException{
        if(FirebaseApp.getApps() == null || FirebaseApp.getApps().isEmpty()){
            logger.info("starting to read JSON object");
            InputStream serviceAccount = FirebaseInitializer.class.getResourceAsStream("/firebase-service-credentials.json");

            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .setDatabaseUrl("https://asi-application-dbb46-default-rtdb.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(options);
        }

    }
}
