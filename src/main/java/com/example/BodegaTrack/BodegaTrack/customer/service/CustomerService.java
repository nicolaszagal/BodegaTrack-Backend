package com.example.BodegaTrack.BodegaTrack.customer.service;


import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Long id, Customer customerDetails);
    void deleteCustomer(Long id);
}
