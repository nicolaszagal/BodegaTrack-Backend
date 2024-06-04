package com.example.BodegaTrack.BodegaTrack.shared.repository;

import com.example.BodegaTrack.BodegaTrack.shared.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Long> {
    boolean existsMovementById(Long id);
}
