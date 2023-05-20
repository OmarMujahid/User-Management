package com.santechture.security.api.security.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

@Component
public class JWTConfiguration {

    @Value("${jwt.config.default.base64.private.key}")
    private String privateKey;


    @Value("${jwt.config.default.base64.public.key}")
    private String publicKey;


    @Autowired
    CipherUtility cipherUtility;


    @Bean
    public KeyPair getKeyPair(){
        return cipherUtility.getKeyPairsFromBase64StringKeys(privateKey,publicKey);
    }

    @Bean
    public JwtDecoder decoder(KeyPair pair){
        return NimbusJwtDecoder.withPublicKey((RSAPublicKey) pair.getPublic()).build();
    }

}
