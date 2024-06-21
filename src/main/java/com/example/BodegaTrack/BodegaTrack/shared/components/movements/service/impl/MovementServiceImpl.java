package com.example.BodegaTrack.BodegaTrack.shared.components.movements.service.impl;

import com.example.BodegaTrack.BodegaTrack.shared.components.movements.model.Movement;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.repository.MovementRepository;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.service.MovementService;
import com.example.BodegaTrack.BodegaTrack.shared.project.exception.ResourceNotFoundException;
import com.example.BodegaTrack.BodegaTrack.shared.project.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementServiceImpl implements MovementService {
    
    @Autowired
    private MovementRepository movementRepository;

    @Override
    public Movement createMovement(Movement movement) {
        existsMovementById(movement);

        return movementRepository.save(movement);
    }

    private void existsMovementById(Movement movement){
        movementRepository.existsMovementById(movement.getId());
        throw new ValidationException("Ya existe un negocio registrado con este email");
    }

    @Override
    public Movement getMovementById(Long id) {
        return movementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro ningun movimiento con el id:" + id));
    }

    @Override
    public List<Movement> getAllMovements() {
        return movementRepository.findAll();
    }

    @Override
    public Movement updateMovement(Long id, Movement movementDetails) {
        Movement movement = getMovementById(id);
        movement.setTitle(movementDetails.getTitle());
        movement.setCost(movementDetails.getCost());
        movement.setType(movementDetails.getType());
        movement.setInterest(movementDetails.getInterest());
        movement.setMovementDate(movementDetails.getMovementDate());
        return movementRepository.save(movement);
    }

    @Override
    public void deleteMovement(Long id) {
        Movement movement = getMovementById(id);
        movementRepository.delete(movement);
    }
    
}
