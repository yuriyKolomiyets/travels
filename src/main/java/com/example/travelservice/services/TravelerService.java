package com.example.travelservice.services;

import com.example.travelservice.model.Traveler;
import com.example.travelservice.model.Trip;

import java.util.Set;

public interface TravelerService {
    Set<Traveler> getTravelers();

    Traveler findById(Long l);

    Traveler saveTraveler(Traveler traveler);

    void deleteById(Long idToDelete);
}
