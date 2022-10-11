package com.example.travelservice.services;

import com.example.travelservice.model.Trip;

import java.util.Set;

public interface TripService {

    Set<Trip> getTrips();

    Trip findById(Long l);

    Trip saveTrip(Trip trip);

    void deleteById(Long idToDelete);

}
