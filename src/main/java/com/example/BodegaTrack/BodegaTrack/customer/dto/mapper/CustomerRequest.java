package com.example.BodegaTrack.BodegaTrack.customer.dto.mapper;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CustomerRequest {
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String password;
}