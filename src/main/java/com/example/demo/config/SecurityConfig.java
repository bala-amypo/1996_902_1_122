package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration              // ✅ Marks this as configuration class
@EnableWebSecurity          // ✅ Enables Spring Security
public class SecurityConfig {

    @Bean                   // ✅ Mandatory in Spring Boot 3+
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())           // disable CSRF (for testing)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()           // allow all requests
            );

        return http.build();
    }

    @Bean                   // ✅ PasswordEncoder bean (fixes your error)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
