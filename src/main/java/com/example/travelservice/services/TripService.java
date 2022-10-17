package com.example.travelservice.services;

import com.example.travelservice.dto.TripDto;
import com.example.travelservice.dto.WeatherDto;
import com.example.travelservice.model.Trip;

import java.util.List;
import java.util.Set;

public interface TripService {

    Trip findById(Long l);

    Trip createTrip(Trip trip);

    List<WeatherDto> showTripWeather(Trip convert);

    Trip updateTrip(Long id, Trip trip);
}
