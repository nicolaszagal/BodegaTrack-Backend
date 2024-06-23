package com.example.BodegaTrack.BodegaTrack.grocer.service;

import com.example.BodegaTrack.BodegaTrack.grocer.model.Grocer;

import java.util.List;

public interface GrocerService {
    Grocer createGrocer(Grocer grocer);
    Grocer getGrocerById(String id);
    List<Grocer> getAllGrocers();
    Grocer updateGrocer(String id, Grocer grocerDetails);
    void deleteGrocer(String id);
}
