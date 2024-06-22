package com.example.BodegaTrack.BodegaTrack.grocer.service.impl;

import com.example.BodegaTrack.BodegaTrack.customer.repository.CustomerRepository;
import com.example.BodegaTrack.BodegaTrack.grocer.model.Grocer;
import com.example.BodegaTrack.BodegaTrack.grocer.repository.GrocerRepository;
import com.example.BodegaTrack.BodegaTrack.grocer.service.GrocerService;
import com.example.BodegaTrack.BodegaTrack.shared.project.exception.ResourceNotFoundException;
import com.example.BodegaTrack.BodegaTrack.shared.project.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrocerServiceImpl implements GrocerService {

    @Autowired
    private GrocerRepository grocerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Grocer createGrocer(Grocer grocer) {
        checkEmailExists(grocer.getEmail());

        return grocerRepository.save(grocer);
    }

    private void checkEmailExists(String email) {
        if (grocerRepository.existsGrocerByEmail(email) || customerRepository.existsCustomerByEmail(email)) {
            throw new ValidationException("Ya existe un usuario registrado con este email");
        }
    }

    @Override
    public Grocer getGrocerById(Long id) {
        return grocerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro ningun bodeguero con el id:" + id));
    }

    @Override
    public List<Grocer> getAllGrocers() {
        return grocerRepository.findAll();
    }

    @Override
    public Grocer updateGrocer(Long id, Grocer grocerDetails) {
        Grocer grocer = getGrocerById(id);
        grocer.setName(grocerDetails.getName());
        grocer.setLastname(grocerDetails.getLastname());
        grocer.setEmail(grocerDetails.getEmail());
        grocer.setPhone(grocerDetails.getPhone());
        grocer.setPassword(grocerDetails.getPassword());
        return grocerRepository.save(grocer);
    }

    @Override
    public void deleteGrocer(Long id) {
        Grocer grocer = getGrocerById(id);
        grocerRepository.delete(grocer);
    }
}
