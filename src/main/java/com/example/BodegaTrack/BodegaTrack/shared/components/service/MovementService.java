package com.example.BodegaTrack.BodegaTrack.shared.components.service;

import com.example.BodegaTrack.BodegaTrack.shared.components.model.Movement;

import java.util.List;

public interface MovementService{
    Movement createMovement(Movement movement);
    Movement getMovementById(Long id);
    List<Movement> getAllMovements();
    Movement updateMovement(Long id, Movement movementDetails);
    void deleteMovement(Long id);
}
