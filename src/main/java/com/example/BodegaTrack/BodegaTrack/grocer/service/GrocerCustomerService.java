package com.example.BodegaTrack.BodegaTrack.grocer.service;

import com.example.BodegaTrack.BodegaTrack.grocer.model.GrocerCustomer;

import java.util.List;

public interface GrocerCustomerService {
    GrocerCustomer createGrocerCustomer(GrocerCustomer grocerCustomer);
    GrocerCustomer getGrocerCustomerById(long id);
    List<GrocerCustomer> getAllGrocerCustomers();
    GrocerCustomer updateGrocerCustomer(Long id, GrocerCustomer grocerCustomerDetails);
    void deleteGrocerCustomer(Long id);
}
