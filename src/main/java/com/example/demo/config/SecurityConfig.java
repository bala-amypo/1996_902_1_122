package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration                  // ✅ Marks config class
@EnableWebSecurity              // ✅ Enables Spring Security
public class SecurityConfig {

    @Bean                       // ✅ Security filter bean (REQUIRED in Boot 3)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())   // ✅ Disable CSRF (for testing)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()  // ✅ Allow all requests
            );

        return http.build();
    }

    @Bean                       // ✅ PasswordEncoder bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
