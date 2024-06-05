package com.example.BodegaTrack.BodegaTrack.grocer.controller;

import com.example.BodegaTrack.BodegaTrack.grocer.model.GrocerCustomer;
import com.example.BodegaTrack.BodegaTrack.grocer.service.GrocerCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grocer-customers")
public class GrocerCustomerController {

    @Autowired
    private GrocerCustomerService grocerCustomerService;

    @PostMapping
    public ResponseEntity<GrocerCustomer> createGrocerCustomer(@RequestBody GrocerCustomer grocerCustomer) {
        GrocerCustomer createdGrocerCustomer = grocerCustomerService.createGrocerCustomer(grocerCustomer);
        return ResponseEntity.ok(createdGrocerCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrocerCustomer> getGrocerCustomerById(@PathVariable Long id) {
        GrocerCustomer grocerCustomer = grocerCustomerService.getGrocerCustomerById(id);
        return ResponseEntity.ok(grocerCustomer);
    }

    @GetMapping
    public ResponseEntity<List<GrocerCustomer>> getAllGrocerCustomers() {
        List<GrocerCustomer> grocerCustomers = grocerCustomerService.getAllGrocerCustomers();
        return ResponseEntity.ok(grocerCustomers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrocerCustomer> updateGrocerCustomer(@PathVariable Long id, @RequestBody GrocerCustomer grocerCustomerDetails) {
        GrocerCustomer updatedGrocerCustomer = grocerCustomerService.updateGrocerCustomer(id, grocerCustomerDetails);
        return ResponseEntity.ok(updatedGrocerCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrocerCustomer(@PathVariable Long id) {
        grocerCustomerService.deleteGrocerCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
