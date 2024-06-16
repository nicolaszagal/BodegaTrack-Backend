package com.example.BodegaTrack.BodegaTrack.grocer.repository;

import com.example.BodegaTrack.BodegaTrack.grocer.model.Grocer;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrocerRepository extends JpaRepository<Grocer, Long> {
    boolean existsGrocerByEmail(String email);
}
