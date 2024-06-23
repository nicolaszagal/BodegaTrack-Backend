package com.example.BodegaTrack.BodegaTrack.shared.components.movements.dto.mapper;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovementResponse {
    private Long id;
    private Long customerId;
    private Long grocerCustomerId;
    private String title;
    private Double cost;
    private String type;
    private Double interest;
    private LocalDate movementDate;
}