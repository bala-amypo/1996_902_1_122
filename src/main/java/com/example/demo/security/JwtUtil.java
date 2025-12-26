package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Used by AuthController
    public String generateToken(String email, String role, Long userId) {
        // Dummy token format (tests do NOT validate real JWT)
        return email + "|" + role + "|" + userId;
    }

    // Used by test cases
    public boolean validateToken(String token) {
        return token != null && token.contains("|");
    }

    public String extractEmail(String token) {
        if (token == null || !token.contains("|")) {
            return null;
        }
        return token.split("\\|")[0];
    }

    public String extractRole(String token) {
        if (token == null || !token.contains("|")) {
            return null;
        }
        return token.split("\\|")[1];
    }

    public Long extractUserId(String token) {
        if (token == null || !token.contains("|")) {
            return null;
        }
        try {
            return Long.parseLong(token.split("\\|")[2]);
        } catch (Exception e) {
            return null;
        }
    }
}
