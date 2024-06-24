package com.example.BodegaTrack.BodegaTrack.shared.components.movements.dto.mapper;

import lombok.Data;


@Data
public class MovementResponse {
    private Long id;
    private String customerId;
    private Long grocerCustomerId;
    private String title;
    private Double cost;
    private String type;
    private Double interest;
    private Integer dues;
    private String movementDate;
}
