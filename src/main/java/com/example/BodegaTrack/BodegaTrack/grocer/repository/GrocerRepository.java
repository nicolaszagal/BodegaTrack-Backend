package com.example.BodegaTrack.BodegaTrack.grocer.repository;

import com.example.BodegaTrack.BodegaTrack.grocer.model.Grocer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrocerRepository extends JpaRepository<Grocer, Long> {
    boolean existsGrocerByEmail(String email);
    Grocer findCurrentGrocer();
    void updateGrocerProfile(Grocer grocer);
}
