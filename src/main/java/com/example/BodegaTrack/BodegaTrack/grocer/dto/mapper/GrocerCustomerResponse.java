package com.example.BodegaTrack.BodegaTrack.grocer.dto.mapper;

import lombok.Data;

@Data
public class GrocerCustomerResponse {
    private String id;
    private String grocerId;
    private String customerId;
    private Double credit;
    private String rateType;
    private Double rate;
    private Boolean configDefault;
    private Double defaultRate;
    private Integer payDay;
    private Integer graceDays;
    private String nextDueDate;
    private Double minimumPayment;
}
