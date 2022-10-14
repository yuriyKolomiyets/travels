package com.example.travelservice.services;

import com.example.travelservice.model.Trip;

import java.util.Set;

public interface TripService {

    Trip findById(Long l);

    Trip createTrip(Trip trip);


}
