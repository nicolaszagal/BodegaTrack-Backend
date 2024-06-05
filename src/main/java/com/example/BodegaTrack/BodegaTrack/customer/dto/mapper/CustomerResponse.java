package com.example.BodegaTrack.BodegaTrack.customer.dto.mapper;

import lombok.Data;

@Data
public class CustomerResponse {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String password;
}
