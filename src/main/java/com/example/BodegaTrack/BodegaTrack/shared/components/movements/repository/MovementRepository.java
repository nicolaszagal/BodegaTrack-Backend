package com.example.BodegaTrack.BodegaTrack.shared.components.movements.repository;

import com.example.BodegaTrack.BodegaTrack.shared.components.movements.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovementRepository extends JpaRepository<Movement, Long> {

}
