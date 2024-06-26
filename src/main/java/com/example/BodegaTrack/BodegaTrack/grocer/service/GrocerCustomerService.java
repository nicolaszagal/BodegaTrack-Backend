package com.example.BodegaTrack.BodegaTrack.grocer.service;

import com.example.BodegaTrack.BodegaTrack.grocer.model.GrocerCustomer;

import java.util.List;

public interface GrocerCustomerService {
    GrocerCustomer createGrocerCustomer(GrocerCustomer grocerCustomer);
    GrocerCustomer getGrocerCustomerById(String id);
    List<GrocerCustomer> getAllGrocerCustomers();
    GrocerCustomer updateGrocerCustomer(String id, GrocerCustomer grocerCustomerDetails);
    void deleteGrocerCustomer(String id);
}