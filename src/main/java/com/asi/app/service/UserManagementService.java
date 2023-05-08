package com.asi.app.service;

import com.asi.app.entity.User;
import com.asi.app.repository.UserRepository;
import com.asi.app.security.Permission;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserManagementService {
    private final FirebaseAuth firebaseAuth;
    private final UserRepository userRepository;


    public void setUserClaims(String uid, List<Permission> requestedPermissions)
            throws FirebaseAuthException{
        List<String> permissions = requestedPermissions
                .stream()
                .map(Enum::toString)
                .collect(Collectors.toList());

        Map<String, Object> claims = Map.of("custom_claims", permissions);
        firebaseAuth.setCustomUserClaims(uid, claims);
    }

    public String register(User user){
        String token = " ";

        try{
            String link = "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyBu5x7bilNi3sTjNfvggdlAOcN2K4cX4KE";
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String infor = "{\"email\":\"" + user.getEmail() + "\",\"password\":\""
                    + user.getPassword() + "\",\"returnSecureToken\":" + "true}";

            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(infor);
            writer.flush();
            writer.close();

            conn.getOutputStream().close();

            InputStream responseStream = conn.getResponseCode()/100 == 2
                    ? conn.getInputStream()
                    :conn.getErrorStream();
            Scanner s = new Scanner(responseStream).useDelimiter("\\A");
            String response = s.hasNext() ? s.next() : " ";
            token = response;

        } catch (Exception e){
            e.printStackTrace();
        }

       return token;
    }

    public String login(User user){
        String token = " ";
        try{
            String link = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyBu5x7bilNi3sTjNfvggdlAOcN2K4cX4KE";
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String infor = "{\"email\":\"" + user.getEmail() + "\",\"password\":\""
                    + user.getPassword() + "\",\"returnSecureToken\":" + "true}";

            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(infor);
            writer.flush();
            writer.close();

            conn.getOutputStream().close();

            InputStream responseStream = conn.getResponseCode()/100 == 2
                    ? conn.getInputStream()
                    :conn.getErrorStream();
            Scanner s = new Scanner(responseStream).useDelimiter("\\A");
            String response = s.hasNext() ? s.next() : " ";
            token = response;
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

}
