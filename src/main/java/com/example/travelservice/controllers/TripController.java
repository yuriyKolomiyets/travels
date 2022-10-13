package com.example.travelservice.controllers;

import com.example.travelservice.model.Location;
import com.example.travelservice.model.Trip;
import com.example.travelservice.services.LocationService;
import com.example.travelservice.services.PersonalInfoService;
import com.example.travelservice.services.TravelerService;
import com.example.travelservice.services.TripService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequiredArgsConstructor
public class TripController {

    private final LocationService locationService;

    @PostMapping(value = "/location")
    public Location createLocation() {
        return locationService.saveLocation(new Location("Paris", "France",
                "hotelName", "48.8567", "2.3510"));
    }

    /*@RequestMapping(value = "/trip", method = GET)
    public Trip createTrip() {
        return tripService.saveTrip(new Trip());
    }*/
}
