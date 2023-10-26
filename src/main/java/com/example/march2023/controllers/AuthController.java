package com.example.march2023.controllers;

import com.example.march2023.dto.JwtResponse;
import com.example.march2023.dto.SignInRequest;
import com.example.march2023.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    @PostMapping("/api/auth/signin")
    public ResponseEntity<JwtResponse> signIn(@RequestBody SignInRequest signInRequest) {
        Authentication authentication = UsernamePasswordAuthenticationToken
                .unauthenticated(signInRequest.getUsername(), signInRequest.getPassword());
        authenticationManager.authenticate(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(signInRequest.getUsername());
        String token = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

}