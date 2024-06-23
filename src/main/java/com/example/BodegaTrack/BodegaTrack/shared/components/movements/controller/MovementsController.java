package com.example.BodegaTrack.BodegaTrack.shared.components.movements.controller;

import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
import com.example.BodegaTrack.BodegaTrack.customer.service.CustomerService;
import com.example.BodegaTrack.BodegaTrack.grocer.model.GrocerCustomer;
import com.example.BodegaTrack.BodegaTrack.grocer.service.GrocerCustomerService;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.dto.mapper.MovementRequest;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.model.Movement;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movements")
public class MovementsController {

    @Autowired
    private MovementService movementService;
    @Autowired
    private GrocerCustomerService grocerCustomerService;
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<Movement> createMovement(@RequestBody MovementRequest request) {
        GrocerCustomer grocerCustomer = grocerCustomerService.getGrocerCustomerById(request.getGrocerCustomerId());

        Movement movement = new Movement();
        movement.setGrocerCustomer(grocerCustomer);
        movement.setTitle(request.getTitle());
        movement.setCost(request.getCost());
        movement.setType(request.getType());
        movement.setInterest(request.getInterest());
        movement.setMovementDate(request.getMovementDate());

        Movement createdMovement = movementService.createMovement(movement);
        return ResponseEntity.ok(createdMovement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movement> getMovementById(@PathVariable Long id) {
        Movement Movement = movementService.getMovementById(id);
        return ResponseEntity.ok(Movement);
    }

    @GetMapping
    public ResponseEntity<List<Movement>> getAllMovements() {
        List<Movement> Movements = movementService.getAllMovements();
        return ResponseEntity.ok(Movements);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movement> updateMovement(@PathVariable Long id, @RequestBody Movement MovementDetails) {
        Movement updatedMovement = movementService.updateMovement(id, MovementDetails);
        return ResponseEntity.ok(updatedMovement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovement(@PathVariable Long id) {
        movementService.deleteMovement(id);
        return ResponseEntity.noContent().build();
    }
}
