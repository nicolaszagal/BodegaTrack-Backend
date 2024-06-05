package com.example.BodegaTrack.BodegaTrack.grocer.dto.mapper;

import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
import com.example.BodegaTrack.BodegaTrack.grocer.model.Grocer;
import lombok.Data;

@Data
public class GrocerCustomerRequest {
    private Grocer grocer;
    private Customer customer;
    private String rateType;
    private Double rate;
    private Boolean configDefault;
    private Double defaultRate;
    private Integer payDay;
    private Integer graceDays;
}
