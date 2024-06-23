package com.example.BodegaTrack.BodegaTrack.grocer.dto.mapper;

import lombok.Data;

@Data
public class GrocerCustomerRequest {
    private Long grocerId;
    private Long customerId;
    private String rateType;
    private Double rate;
    private Boolean configDefault;
    private Double defaultRate;
    private Integer payDay;
    private Integer graceDays;
}
