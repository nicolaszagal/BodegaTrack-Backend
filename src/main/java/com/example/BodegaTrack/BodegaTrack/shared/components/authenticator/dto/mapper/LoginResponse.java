package com.example.BodegaTrack.BodegaTrack.shared.components.authenticator.dto.mapper;

import lombok.Data;

@Data
public class LoginResponse {
    private String name;
    private String email;
    private String phone;
    private String id;
    private String role;

    public LoginResponse(String name, String email, String phone, String id, String role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.id = id;
        this.role = role;
    }
}
