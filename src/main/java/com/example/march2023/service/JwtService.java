package com.example.march2023.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    boolean isTokenExpired(String token);

    String extractUsername(String token);

    String generateToken(UserDetails userDetails);
}
