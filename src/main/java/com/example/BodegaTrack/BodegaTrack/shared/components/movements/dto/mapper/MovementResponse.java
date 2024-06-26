package com.example.BodegaTrack.BodegaTrack.shared.components.movements.dto.mapper;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovementResponse {
    private Long id;
    private String customerId;
    private String grocerCustomerId;
    private String title;
    private Double cost;
    private String type;
    private Integer dues;
    private Double interest;
    private String movementDate;
}
