package com.example.travelservice.controllers;

import com.example.travelservice.dto.LocationDto;
import com.example.travelservice.model.Location;
import com.example.travelservice.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocationController {

    LocationService locationService;

    @PostMapping(value = "/location")
    public Location createLocation(@RequestBody LocationDto locationDto) {

        return locationService.saveLocation(locationDto.convertToLocation());
    }
}
