package com.example.BodegaTrack.BodegaTrack.customer.repository;

import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
import com.example.BodegaTrack.BodegaTrack.grocer.model.Grocer;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
   boolean existsCustomerByEmail(String email);
   Optional<Customer> findCustomerByEmail(String email);
}
