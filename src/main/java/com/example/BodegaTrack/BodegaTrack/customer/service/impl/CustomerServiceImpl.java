package com.example.BodegaTrack.BodegaTrack.customer.service.impl;

import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
import com.example.BodegaTrack.BodegaTrack.customer.repository.CustomerRepository;
import com.example.BodegaTrack.BodegaTrack.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Customer createCustomer(Customer customer) {
        customerRepository.existsCustomerByEmail(String.valueOf(customer));

        return customerRepository.save(customer);
    }

    @Override
    public Customer findCurrentCustomer() {
        return null;
    }

    @Override
    public void updateCustomerProfile(Customer customer) {

    }
}
