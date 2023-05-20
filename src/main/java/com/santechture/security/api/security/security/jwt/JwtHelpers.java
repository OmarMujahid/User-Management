package com.santechture.security.api.security.security.jwt;

import com.santechture.security.data.model.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.util.Date;

@Component
@Slf4j
public class JwtHelpers {

    @Autowired
    KeyPair keyPair;

    public String createToken(User user){

        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(user.getUserName())
                .setExpiration(new Date(new Date().getTime() + 24 * 60 * 60 * 1000))
                .claim("id",user.getId())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.RS256, keyPair.getPrivate())
                ;

        return  jwtBuilder.compact();
    }


}
