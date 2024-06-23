package com.example.BodegaTrack.BodegaTrack.grocer.repository;

import com.example.BodegaTrack.BodegaTrack.grocer.model.Grocer;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GrocerRepository extends JpaRepository<Grocer, String> {
    boolean existsGrocerByEmail(String email);
    Optional<Grocer> findGrocerByEmail(String email);
}
