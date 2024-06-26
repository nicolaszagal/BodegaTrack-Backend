package com.example.BodegaTrack.BodegaTrack.shared.components.movements.dto.mapper;
import com.example.BodegaTrack.BodegaTrack.grocer.model.GrocerCustomer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentRequest {
    private GrocerCustomer grocerCustomer;
    private Double amount;
    private LocalDate paymentDate;
    private Double lateFee;
}
