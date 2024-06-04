package com.example.BodegaTrack.BodegaTrack.customer.service;
import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer findCurrentCustomer();
    void updateCustomerProfile(Customer customer);
}
