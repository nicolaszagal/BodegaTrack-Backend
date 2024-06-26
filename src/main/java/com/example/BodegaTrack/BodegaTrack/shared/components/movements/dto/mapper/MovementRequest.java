package com.example.BodegaTrack.BodegaTrack.shared.components.movements.dto.mapper;
import lombok.Data;
import java.time.LocalDate;

@Data
public class MovementRequest {
    private Long grocerCustomerId;
    private String customerId;
    private String title;
    private Double cost;
    private String type;
    private Double interest;
    private LocalDate movementDate;
}
