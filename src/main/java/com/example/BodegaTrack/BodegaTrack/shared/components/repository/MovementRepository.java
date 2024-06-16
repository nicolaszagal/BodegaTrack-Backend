package com.example.BodegaTrack.BodegaTrack.shared.components.repository;

import com.example.BodegaTrack.BodegaTrack.shared.components.model.Movement;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovementRepository extends JpaRepository<Movement, Long> {
    boolean existsMovementById(Long id);
}
