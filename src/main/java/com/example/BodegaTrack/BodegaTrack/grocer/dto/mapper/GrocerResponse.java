package com.example.BodegaTrack.BodegaTrack.grocer.dto.mapper;

import lombok.Data;

@Data
public class GrocerResponse {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String password;
}
