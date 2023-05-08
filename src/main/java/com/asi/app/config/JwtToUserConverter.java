//package com.asi.app.config;
//
//import com.asi.app.entity.User;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//@Component
//public class JwtToUserConverter implements Converter<Jwt, UsernamePasswordAuthenticationToken> {
//    @Override
//    public UsernamePasswordAuthenticationToken covert(Jwt jwt){
//        User user = new User();
//        user.setId(jwt.getSubject());
//        return new UsernamePasswordAuthenticationToken(user, jwt, Collections.EMPTY_LIST);
//    }
//
//    @Override
//    public UsernamePasswordAuthenticationToken convert(Jwt source) {
//        return null;
//    }
//}
