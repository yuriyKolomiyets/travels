package com.example.travelservice.controllers;

import com.example.travelservice.dto.LocationDto;
import com.example.travelservice.dtoconverters.LocationConverter;
import com.example.travelservice.model.Location;
import com.example.travelservice.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;
    private final LocationConverter locationConverter;

    @PostMapping(value = "/location/create")
    public Location createLocation(@RequestBody LocationDto locationDto) {

        return locationService.saveLocation(locationConverter.convert(locationDto));
    }
}
