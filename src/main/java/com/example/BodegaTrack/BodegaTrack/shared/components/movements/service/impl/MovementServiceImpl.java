package com.example.BodegaTrack.BodegaTrack.shared.components.movements.service.impl;

import com.example.BodegaTrack.BodegaTrack.grocer.model.GrocerCustomer;
import com.example.BodegaTrack.BodegaTrack.grocer.repository.GrocerCustomerRepository;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.model.Movement;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.repository.MovementRepository;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.service.MovementService;
import com.example.BodegaTrack.BodegaTrack.shared.project.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
@Transactional
public class MovementServiceImpl implements MovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private GrocerCustomerRepository grocerCustomerRepository;

    @Override
    public Movement createMovement(Movement movement) {
        calculateInterest(movement);
        Movement savedMovement = movementRepository.save(movement);
        updateGrocerCustomerCredit(movement.getGrocerCustomer().getId());
        return savedMovement;
    }

    @Override
    public Movement getMovementById(Long id) {
        return movementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró ningún movimiento con el id:" + id));
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
        movement.setDues(movementDetails.getDues());
        movement.setMovementDate(movementDetails.getMovementDate());

        calculateInterest(movement);
        Movement updatedMovement = movementRepository.save(movement);
        updateGrocerCustomerCredit(movement.getGrocerCustomer().getId());
        return updatedMovement;
    }

    @Transactional
    @Override
    public void deleteMovement(Long id) {
        Movement movement = getMovementById(id);
        if (movement != null) {
            movementRepository.deleteById(id);
            updateGrocerCustomerCredit(movement.getGrocerCustomer().getId());
        } else {
            throw new ResourceNotFoundException("Movement not found with id " + id);
        }
    }

    private void calculateInterest(Movement movement) {
        double cost = movement.getCost();
        double dues = movement.getDues();
        double rate = movement.getGrocerCustomer().getRate();
        String rateType = movement.getGrocerCustomer().getRateType();
        double exponent = dues / 12;

        if ("tasa_efectiva".equals(rateType)) {
            movement.setInterest((cost * Math.pow((1 + rate), exponent)) - cost);
        } else {
            movement.setInterest((cost * (1 + (rate / 100))) - cost);
        }

        // Formatear interés a dos decimales
        DecimalFormat df = new DecimalFormat("#.##");
        movement.setInterest(Double.parseDouble(df.format(movement.getInterest())));
    }

    private void updateGrocerCustomerCredit(String grocerCustomerId) {
        GrocerCustomer grocerCustomer = grocerCustomerRepository.findById(grocerCustomerId)
                .orElseThrow(() -> new ResourceNotFoundException("GrocerCustomer not found with id " + grocerCustomerId));
        grocerCustomer.updateCreditValues();
        grocerCustomerRepository.save(grocerCustomer);
    }
}
