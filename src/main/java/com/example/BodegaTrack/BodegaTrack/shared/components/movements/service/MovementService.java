package com.example.BodegaTrack.BodegaTrack.shared.components.movements.service;

import com.example.BodegaTrack.BodegaTrack.shared.components.movements.model.Movement;

import java.util.List;

public interface MovementService{
    Movement createMovement(Movement movement);
    Movement getMovementById(Long id);
    List<Movement> getAllMovements();
    Movement updateMovement(Long id, Movement movementDetails);
    void deleteMovement(Long id);
}
