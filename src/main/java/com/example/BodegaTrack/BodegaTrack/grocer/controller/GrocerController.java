package com.example.BodegaTrack.BodegaTrack.grocer.controller;

import com.example.BodegaTrack.BodegaTrack.grocer.model.Grocer;
import com.example.BodegaTrack.BodegaTrack.grocer.service.GrocerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grocers")
public class GrocerController {

    @Autowired
    private GrocerService grocerService;

    @PostMapping
    public ResponseEntity<Grocer> createGrocer(@RequestBody Grocer grocer) {
        Grocer createdGrocer = grocerService.createGrocer(grocer);
        return ResponseEntity.ok(createdGrocer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grocer> getGrocerById(@PathVariable String id) {
        Grocer grocer = grocerService.getGrocerById(id);
        return ResponseEntity.ok(grocer);
    }

    @GetMapping
    public ResponseEntity<List<Grocer>> getAllGrocers() {
        List<Grocer> grocers = grocerService.getAllGrocers();
        return ResponseEntity.ok(grocers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grocer> updateGrocer(@PathVariable String id, @RequestBody Grocer grocerDetails) {
        Grocer updatedGrocer = grocerService.updateGrocer(id, grocerDetails);
        return ResponseEntity.ok(updatedGrocer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrocer(@PathVariable String id) {
        grocerService.deleteGrocer(id);
        return ResponseEntity.noContent().build();
    }
}
