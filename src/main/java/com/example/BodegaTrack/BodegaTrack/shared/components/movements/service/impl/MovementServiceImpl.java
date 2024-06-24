package com.example.BodegaTrack.BodegaTrack.shared.components.movements.service.impl;

import com.example.BodegaTrack.BodegaTrack.shared.components.movements.model.Movement;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.repository.MovementRepository;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.service.MovementService;
import com.example.BodegaTrack.BodegaTrack.shared.project.exception.ResourceNotFoundException;
import com.example.BodegaTrack.BodegaTrack.shared.project.exception.ValidationException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MovementServiceImpl implements MovementService {
    
    @Autowired
    private MovementRepository movementRepository;

    @Override
    public Movement createMovement(Movement movement) {
        calculateInterest(movement);
        return movementRepository.save(movement);
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

        calculateInterest(movement);

        return movementRepository.save(movement);
    }

    @Transactional
    @Override
    public void deleteMovement(Long id) {
        if (movementRepository.existsById(id)) {
            movementRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Movement not found with id " + id);
        }
    }


    private void calculateInterest(Movement movement) {
        double cost = movement.getCost();
        int dues = movement.getDues();
        double rate = movement.getGrocerCustomer().getRate();
        String rateType = movement.getGrocerCustomer().getRateType();

        if ("tasa_efectiva".equals(rateType)) {
            movement.setInterest((cost * ((dues + rate)/dues)) - cost);
        } else {
            movement.setInterest((cost * (1 + (rate / 100))) - cost);
        }
    }
}
