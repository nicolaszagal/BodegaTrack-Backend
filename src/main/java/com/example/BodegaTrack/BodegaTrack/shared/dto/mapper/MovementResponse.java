package com.example.BodegaTrack.BodegaTrack.shared.dto.mapper;

import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MovementResponse {
    private Long id;
    private Customer customer;
    private String title;
    private Double cost;
    private String type;
    private Double interest;
    private LocalDate movementDate;
}
