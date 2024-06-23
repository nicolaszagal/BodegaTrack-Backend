package com.example.BodegaTrack.BodegaTrack.customer.service.impl;

import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
import com.example.BodegaTrack.BodegaTrack.customer.repository.CustomerRepository;
import com.example.BodegaTrack.BodegaTrack.customer.service.CustomerService;
import com.example.BodegaTrack.BodegaTrack.grocer.model.Grocer;
import com.example.BodegaTrack.BodegaTrack.grocer.repository.GrocerRepository;
import com.example.BodegaTrack.BodegaTrack.shared.project.exception.ResourceNotFoundException;
import com.example.BodegaTrack.BodegaTrack.shared.project.exception.ValidationException;
import jakarta.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private GrocerRepository grocerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        checkEmailExists(customer.getEmail());
        customer.setId(generatedUniqueId());
        return customerRepository.save(customer);
    }

    private void checkEmailExists(String email) {
        if (customerRepository.existsCustomerByEmail(email) || grocerRepository.existsGrocerByEmail(email)) {
            throw new ValidationException("Ya existe un usuario registrado con este email");
        }
    }

    private String generatedUniqueId() {
        String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder uniqueId = new StringBuilder(6);
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(alphanumeric.length());
            uniqueId.append(alphanumeric.charAt(index));
        }
        return uniqueId.toString();
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No se encontro ningun cliente con el id:" + id));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(String id, Customer customerDetails) {
        Customer customer = getCustomerById(id);
        customer.setName(customerDetails.getName());
        customer.setLastname(customerDetails.getLastname());
        customer.setEmail(customerDetails.getEmail());
        customer.setPhone(customerDetails.getPhone());
        customer.setPassword(customerDetails.getPassword());
        return customerRepository.save(customer);
    }


    @Override
    public void deleteCustomer(String id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }

}
