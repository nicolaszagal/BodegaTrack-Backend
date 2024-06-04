package com.example.BodegaTrack.BodegaTrack.grocer.service;

import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
import com.example.BodegaTrack.BodegaTrack.grocer.model.Grocer;
import com.example.BodegaTrack.BodegaTrack.grocer.model.GrocerCustomer;

public interface GrocerCustomerService {
    Grocer createCustomerGrocer(GrocerCustomer grocerCustomer);
    Customer findByCustomerId(Long customerId);
}
