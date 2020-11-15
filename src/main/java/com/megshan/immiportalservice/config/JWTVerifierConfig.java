package com.megshan.immiportalservice.config;

import com.okta.jwt.AccessTokenVerifier;
import com.okta.jwt.JwtVerifiers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class JWTVerifierConfig {

    @Bean
    public AccessTokenVerifier jwtVerifier() {
        return JwtVerifiers.accessTokenVerifierBuilder()
                .setIssuer("https://dev-565937.okta.com/oauth2/default")
                .setAudience("api://default")                // defaults to 'api://default'
                .setConnectionTimeout(Duration.ofSeconds(1)) // defaults to 1s
                .setReadTimeout(Duration.ofSeconds(1))       // defaults to 1s
                .build();
    }
}
