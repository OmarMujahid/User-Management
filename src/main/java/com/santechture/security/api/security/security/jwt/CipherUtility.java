package com.santechture.security.api.security.security.jwt;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.UUID;

@Component
public class CipherUtility {

    private static KeyPairGenerator keyPairGenerator = null;

    private String guid;

    private SecureRandom random;

    private KeyPair keyPair;



    @PostConstruct
    private void init() {
        try {
            guid = UUID.randomUUID().toString();
            random = new SecureRandom(guid.getBytes(StandardCharsets.UTF_8));
            if(keyPairGenerator == null) keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024, random);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public String getGuid(){
        return guid;
    }

    public KeyPair getNewKeyPair() {

        guid = UUID.randomUUID().toString();

        random = new SecureRandom(guid.getBytes(StandardCharsets.UTF_8));

        keyPair = keyPairGenerator.genKeyPair();

        return keyPair;
    }


    public KeyPair getKeyPairsFromBase64StringKeys(String base64PrivateKey,String base64PublicKey){

        try{

            PrivateKey privateKey = decodePrivateKey(base64PrivateKey);

            PublicKey publicKey = decodePublicKey(base64PublicKey);

            return new KeyPair(publicKey,privateKey);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public PublicKey decodePublicKey(String keyStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = Base64.getDecoder().decode(keyStr);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PublicKey key = keyFactory.generatePublic(spec);
        return keyFactory.generatePublic(spec);
    }

    public PrivateKey decodePrivateKey(String keyStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = Base64.getDecoder().decode(keyStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PrivateKey key = keyFactory.generatePrivate(keySpec);
        return keyFactory.generatePrivate(keySpec);
    }

}
