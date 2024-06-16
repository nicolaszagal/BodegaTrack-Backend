package com.example.BodegaTrack.BodegaTrack.customer.service.impl;

import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
import com.example.BodegaTrack.BodegaTrack.customer.repository.CustomerRepository;
import com.example.BodegaTrack.BodegaTrack.customer.service.CustomerService;
import com.example.BodegaTrack.BodegaTrack.shared.project.exception.ResourceNotFoundException;
import com.example.BodegaTrack.BodegaTrack.shared.project.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        existsCustomerByEmail(customer);

        return customerRepository.save(customer);
    }

    private void existsCustomerByEmail(Customer customer) {
        if (customerRepository.existsCustomerByEmail(customer.getEmail())){
            throw  new ValidationException("Ya existe un cliente registrado con este email");
        }
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No se encontro ningun cliente con el id:" + id));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = getCustomerById(id);
        customer.setName(customerDetails.getName());
        customer.setLastname(customerDetails.getName());
        customer.setEmail(customerDetails.getName());
        customer.setPhone(customerDetails.getName());
        customer.setPassword(customerDetails.getName());
        return customerRepository.save(customer);
    }


    @Override
    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}
