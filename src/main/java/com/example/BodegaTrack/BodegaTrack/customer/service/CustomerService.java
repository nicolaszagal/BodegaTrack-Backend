package com.example.BodegaTrack.BodegaTrack.customer.service;
import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;

public interface CustomerService {
    Customer findCurrentCustomer();
    void updateCustomerProfile(Customer customer);
    Customer createCustomer(Customer customer);
}
