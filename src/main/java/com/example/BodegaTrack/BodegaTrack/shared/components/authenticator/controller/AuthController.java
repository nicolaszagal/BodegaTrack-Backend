package com.example.BodegaTrack.BodegaTrack.shared.components.authenticator.controller;

import com.example.BodegaTrack.BodegaTrack.shared.components.authenticator.dto.mapper.LoginRequest;
import com.example.BodegaTrack.BodegaTrack.shared.components.authenticator.dto.mapper.LoginResponse;
import com.example.BodegaTrack.BodegaTrack.shared.components.authenticator.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        try {
            LoginResponse response = authService.login(loginRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}
