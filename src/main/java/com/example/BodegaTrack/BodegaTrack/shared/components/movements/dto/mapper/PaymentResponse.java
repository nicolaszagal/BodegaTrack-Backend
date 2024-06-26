package com.example.BodegaTrack.BodegaTrack.shared.components.movements.dto.mapper;
import com.example.BodegaTrack.BodegaTrack.grocer.model.GrocerCustomer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentResponse {
    private Long id;
    private GrocerCustomer grocerCustomer;
    private Double amount;
    private LocalDate paymentDate;
    private Double lateFee;
}