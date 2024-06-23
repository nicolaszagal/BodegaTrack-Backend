package com.example.BodegaTrack.BodegaTrack.grocer.controller;

import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
import com.example.BodegaTrack.BodegaTrack.customer.service.CustomerService;
import com.example.BodegaTrack.BodegaTrack.grocer.dto.mapper.GrocerCustomerRequest;
import com.example.BodegaTrack.BodegaTrack.grocer.model.Grocer;
import com.example.BodegaTrack.BodegaTrack.grocer.model.GrocerCustomer;
import com.example.BodegaTrack.BodegaTrack.grocer.service.GrocerCustomerService;
import com.example.BodegaTrack.BodegaTrack.grocer.service.GrocerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grocer-customers")


public class GrocerCustomerController {

    @Autowired
    private GrocerCustomerService grocerCustomerService;
    @Autowired
    GrocerService grocerService;
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<GrocerCustomer> createGrocerCustomer(@RequestBody GrocerCustomerRequest request) {
        Grocer grocer = grocerService.getGrocerById(request.getGrocerId());
        Customer customer = customerService.getCustomerById(request.getCustomerId());

        GrocerCustomer grocerCustomer = new GrocerCustomer();
        grocerCustomer.setGrocer(grocer);
        grocerCustomer.setCustomer(customer);
        grocerCustomer.setRateType(request.getRateType());
        grocerCustomer.setRate(request.getRate());
        grocerCustomer.setConfigDefault(request.getConfigDefault());
        grocerCustomer.setDefaultRate(request.getDefaultRate());
        grocerCustomer.setPayDay(request.getPayDay());
        grocerCustomer.setGraceDays(request.getGraceDays());

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
