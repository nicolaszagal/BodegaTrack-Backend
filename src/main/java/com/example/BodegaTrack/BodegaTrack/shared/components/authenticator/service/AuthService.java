package com.example.BodegaTrack.BodegaTrack.shared.components.authenticator.service;

import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
import com.example.BodegaTrack.BodegaTrack.customer.repository.CustomerRepository;
import com.example.BodegaTrack.BodegaTrack.grocer.model.Grocer;
import com.example.BodegaTrack.BodegaTrack.grocer.repository.GrocerRepository;
import com.example.BodegaTrack.BodegaTrack.shared.components.authenticator.dto.mapper.LoginRequest;
import com.example.BodegaTrack.BodegaTrack.shared.components.authenticator.dto.mapper.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private GrocerRepository grocerRepository;

    public LoginResponse login(LoginRequest loginRequest){
        Customer customer = customerRepository.findCustomerByEmail(loginRequest.getEmail()).orElse(null);
        if(customer != null && customer.getPassword().equals(loginRequest.getPassword())){
            return new LoginResponse(customer.getName(), customer.getEmail(), customer.getPhone(), customer.getId().toString(), "customer");
        }

        Grocer grocer = grocerRepository.findGrocerByEmail(loginRequest.getEmail()).orElse(null);
        if (grocer != null && grocer.getPassword().equals(loginRequest.getPassword())) {
            return new LoginResponse(grocer.getName(), grocer.getEmail(), grocer.getPhone(), grocer.getId().toString(), "grocer");
        }

        throw new RuntimeException("Invalid email or password");
    }
}
