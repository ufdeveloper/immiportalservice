package com.megshan.immiportalservice.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // To disable security
//        http.authorizeRequests(authorizeRequests ->
//                        authorizeRequests.antMatchers("/**").permitAll()
//                                .anyRequest().authenticated())
//                .csrf().disable();

        // To enable JWT authorization
        http
                .cors() // This needs to be added to exclude the OPTIONS call from needing authentication
                        // More info here - https://www.baeldung.com/spring-security-cors-preflight
                .and()
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests.anyRequest().authenticated())
                .oauth2ResourceServer().jwt();
    }
}
