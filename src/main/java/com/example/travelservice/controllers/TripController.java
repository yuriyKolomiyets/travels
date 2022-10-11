package com.example.travelservice.controllers;

import com.example.travelservice.model.Trip;
import com.example.travelservice.services.TripService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    @RequestMapping(value = "/trip", method = GET)
    public Trip createTrip() {
        return tripService.saveTrip(new Trip());
    }
}
