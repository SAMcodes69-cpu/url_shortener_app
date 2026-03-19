package com.sadbhav.urlshortener.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration    // Tells Spring this class defines the app's setup.
public class SecurityConfig {
    @Bean // to create an object of that method once per startup and use it everywhere without initializing again
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
