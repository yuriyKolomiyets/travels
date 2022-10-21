package com.example.travelservice.dtoconverters;

import com.example.travelservice.dto.TripDto;
import com.example.travelservice.dto.WeatherRequest;
import com.example.travelservice.model.Location;
import com.example.travelservice.model.Meal;
import com.example.travelservice.model.Trip;
import com.example.travelservice.repositories.TravelerRepository;
import com.example.travelservice.services.LocationService;
import org.springframework.stereotype.Component;

@Component
public class TripConverter {

    private final LocationService locationService;
    private final TravelerRepository travelerRepository;

    public TripConverter(LocationService locationService, TravelerRepository travelerRepository) {
        this.locationService = locationService;
        this.travelerRepository = travelerRepository;
    }


    public Trip convertTripDtoToTrip (TripDto source) {
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

    public WeatherRequest convertTripToWeatherRequest (Trip source) {
        if (source == null) {
            return null;
        }

        return new WeatherRequest(
                Double.valueOf(source.getLocation().getLatitude()),
                Double.valueOf(source.getLocation().getLongitude())
        );
    }


}
