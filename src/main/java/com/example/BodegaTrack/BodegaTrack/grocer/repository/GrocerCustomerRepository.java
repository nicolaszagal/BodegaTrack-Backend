package com.example.BodegaTrack.BodegaTrack.grocer.repository;

import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
import com.example.BodegaTrack.BodegaTrack.grocer.model.GrocerCustomer;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrocerCustomerRepository extends JpaRepository<GrocerCustomer, String> {
    boolean existsGrocerById(String customerId);
}