package com.example.march2023.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtServiceImpl implements JwtService {
    @Value("${jwt.signingKey}")
    private String signingKey;

    private Key key;

    @PostConstruct
    public void

    @Override
    public boolean isTokenExpired(String token) {
        return false;
    }

    @Override
    public String extractUsername(String token) {
        return null;
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return null;
    }
}
