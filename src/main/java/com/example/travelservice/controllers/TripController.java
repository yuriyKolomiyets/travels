package com.example.travelservice.controllers;

import com.example.travelservice.dto.TripDto;
import com.example.travelservice.dtoconverters.TripConverter;
import com.example.travelservice.model.Trip;
import com.example.travelservice.services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;
    private final TripConverter tripConverter;

    @PostMapping(value = "/create/trip")
    public Trip createTrip(@RequestBody TripDto tripDto) {
        return tripService.createTrip(tripConverter.convert(tripDto));
    }
}
