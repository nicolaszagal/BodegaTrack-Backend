package com.example.BodegaTrack.BodegaTrack.shared.components.movements.dto.mapper;
import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import java.time.LocalDate;

@Data
public class MovementRequest {
    private String grocerCustomerId;
    private String customerId;
    private String title;
    private Double cost;
    private String type;
    private Double interest;
    private Integer dues;
    private String movementDate;
}
