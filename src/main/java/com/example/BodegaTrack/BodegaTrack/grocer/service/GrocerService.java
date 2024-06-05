package com.example.BodegaTrack.BodegaTrack.grocer.service;

import com.example.BodegaTrack.BodegaTrack.grocer.model.Grocer;

import java.util.List;

public interface GrocerService {
    Grocer createGrocer(Grocer grocer);
    Grocer getGrocerById(Long id);
    List<Grocer> getAllGrocers();
    Grocer updateGrocer(Long id, Grocer grocerDetails);
    void deleteGrocer(Long id);
}
