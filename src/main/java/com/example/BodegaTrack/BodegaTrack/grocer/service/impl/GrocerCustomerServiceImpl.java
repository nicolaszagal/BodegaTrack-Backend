package com.example.BodegaTrack.BodegaTrack.grocer.service.impl;

import com.example.BodegaTrack.BodegaTrack.grocer.model.GrocerCustomer;
import com.example.BodegaTrack.BodegaTrack.grocer.repository.GrocerCustomerRepository;
import com.example.BodegaTrack.BodegaTrack.grocer.service.GrocerCustomerService;
import com.example.BodegaTrack.BodegaTrack.shared.project.exception.ResourceNotFoundException;
import com.example.BodegaTrack.BodegaTrack.shared.project.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrocerCustomerServiceImpl implements GrocerCustomerService {

    @Autowired
    private GrocerCustomerRepository grocerCustomerRepository;

    @Override
    public GrocerCustomer createGrocerCustomer(GrocerCustomer grocerCustomer) {
        existsGrocerById(grocerCustomer);

        grocerCustomer.setUsedCredit(0.0);
        grocerCustomer.setAvailableCredit(grocerCustomer.getCredit());

        return grocerCustomerRepository.save(grocerCustomer);
    }

    private void existsGrocerById(GrocerCustomer grocerCustomer){
        if (grocerCustomerRepository.existsGrocerById(grocerCustomer.getId())) {
            throw new ValidationException("Ya has registrado un cliente con este id");
        }
    }

    @Override
    public GrocerCustomer getGrocerCustomerById(Long id) {
        return grocerCustomerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No tienes ningun cliente registrado con el id:" + id));
    }

    @Override
    public List<GrocerCustomer> getAllGrocerCustomers() {
        return grocerCustomerRepository.findAll();
    }

    @Override
    public GrocerCustomer updateGrocerCustomer(Long id, GrocerCustomer grocerCustomerDetails) {
        GrocerCustomer grocerCustomer = getGrocerCustomerById(id);
        grocerCustomer.setRateType(grocerCustomerDetails.getRateType());
        grocerCustomer.setRate(grocerCustomerDetails.getRate());
        grocerCustomer.setConfigDefault(grocerCustomerDetails.getConfigDefault());
        grocerCustomer.setDefaultRate(grocerCustomerDetails.getDefaultRate());
        grocerCustomer.setPayDay(grocerCustomerDetails.getPayDay());
        grocerCustomer.setGraceDays(grocerCustomerDetails.getGraceDays());
        return grocerCustomerRepository.save(grocerCustomer);
    }

    @Override
    public void deleteGrocerCustomer(Long id) {
        GrocerCustomer grocerCustomer = grocerCustomerRepository.findById(id).orElse(null);
        grocerCustomerRepository.delete(grocerCustomer);
    }
}