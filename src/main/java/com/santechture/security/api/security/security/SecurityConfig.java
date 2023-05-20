//package com.santechture.security.api.security.security;
//
//import com.nimbusds.jose.jwk.JWK;
//import com.nimbusds.jose.jwk.JWKSet;
//import com.nimbusds.jose.jwk.RSAKey;
//import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
//import com.nimbusds.jose.jwk.source.JWKSource;
//import com.nimbusds.jose.proc.SecurityContext;
//import org.bouncycastle.util.io.pem.PemReader;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.JwtEncoder;
//import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
//import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
//import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
//import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
//import org.springframework.security.web.SecurityFilterChain;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.security.KeyFactory;
//import java.security.NoSuchAlgorithmException;
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//import java.security.spec.InvalidKeySpecException;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(csrf -> csrf.disable())
//                .authorizeRequests(auth -> auth
//                        .mvcMatchers("/api/authenticate").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//                .exceptionHandling((ex) -> ex
//                        .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
//                        .accessDeniedHandler(new BearerTokenAccessDeniedHandler())
//                )
//                .httpBasic(Customizer.withDefaults()) //
//                .build();
//    }
//
//    @Bean
//    public JwtDecoder jwtDecoder() {
//        RSAPublicKey publicKey;
//        try {
//            KeyFactory kf = KeyFactory.getInstance("RSA");
//            InputStream resource = new ClassPathResource(
//                    "keys/public.key").getInputStream();
//
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
//                byte[] publicKeyBytes = new PemReader(reader).readPemObject().getContent();
//                publicKey = (RSAPublicKey) kf.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
//            }
//            return NimbusJwtDecoder.withPublicKey(publicKey).build();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (InvalidKeySpecException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Bean
//    public JwtEncoder jwtEncoder() {
//        try {
//            KeyFactory kf = KeyFactory.getInstance("RSA");
//
//            RSAPrivateKey privateKey;
//            InputStream resource = new ClassPathResource(
//                    "keys/private.key").getInputStream();
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
//                byte[] privateKeyBytes = new PemReader(reader).readPemObject().getContent();
//                privateKey = (RSAPrivateKey) kf.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
//            }
//            RSAPublicKey publicKey;
//            resource = new ClassPathResource(
//                    "keys/public.key").getInputStream();
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
//                byte[] publicKeyBytes = new PemReader(reader).readPemObject().getContent();
//                publicKey = (RSAPublicKey) kf.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
//            }
//            JWK jwk = new RSAKey.Builder(publicKey).privateKey(privateKey).build();
//            JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
//            return new NimbusJwtEncoder(jwks);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (InvalidKeySpecException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
