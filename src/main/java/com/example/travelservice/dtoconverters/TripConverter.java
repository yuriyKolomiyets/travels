package com.example.travelservice.dtoconverters;

import com.example.travelservice.dto.TripDto;
import com.example.travelservice.model.Meal;
import com.example.travelservice.model.Trip;
import com.example.travelservice.services.LocationService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TripConverter {

    private final LocationService locationService;

    public TripConverter(LocationService locationService) {
        this.locationService = locationService;
    }


    public Trip convert(TripDto source) {
        if (source == null) {
            return null;
        }
        return new Trip(source.getStartDate(), source.getEndDate(), locationService.findById(source.getLocationId()),
                new ArrayList<>(), Enum.valueOf(Meal.class, source.getMeal()));
    }

}
