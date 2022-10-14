package com.example.travelservice.dtoconverters;

import com.example.travelservice.dto.TripDto;
import com.example.travelservice.model.Location;
import com.example.travelservice.model.Meal;
import com.example.travelservice.model.Traveler;
import com.example.travelservice.model.Trip;
import com.example.travelservice.repositories.TravelerRepository;
import com.example.travelservice.services.LocationService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TripConverter {

    private final LocationService locationService;
    private final TravelerRepository travelerRepository;

    public TripConverter(LocationService locationService, TravelerRepository travelerRepository) {
        this.locationService = locationService;
        this.travelerRepository = travelerRepository;
    }


    public Trip convert(TripDto source) {
        if (source == null) {
            return null;
        }

        Location location = locationService.findById(source.getLocationId());
        return new Trip(
                source.getStartDate(),
                source.getEndDate(),
                location,
                source.getTravelers(),
                Enum.valueOf(Meal.class, source.getMeal()));
    }
}
