package com.example.BodegaTrack.BodegaTrack.customer.repository;

import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
import com.example.BodegaTrack.BodegaTrack.grocer.model.Grocer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
   boolean existsByEmail(String email);
}
