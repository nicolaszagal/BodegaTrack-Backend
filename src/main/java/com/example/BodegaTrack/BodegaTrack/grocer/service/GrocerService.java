package com.example.BodegaTrack.BodegaTrack.grocer.service;

import com.example.BodegaTrack.BodegaTrack.grocer.model.Grocer;

public interface GrocerService {
    Grocer createGrocer(Grocer grocer);
    Grocer findCurrentGrocer();
    void updateGrocerProfile(Grocer grocer);
}
