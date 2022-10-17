package com.example.travelservice.controllers;

import com.example.travelservice.dto.LocationDto;
import com.example.travelservice.dtoconverters.LocationConverter;
import com.example.travelservice.model.Location;
import com.example.travelservice.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
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
        return locationService.createLocation(locationConverter.convert(locationDto));
    }

    @PostMapping("location/id/{locationId}/update")
    public Location updateCity(@PathVariable Long locationId, @RequestBody String cityName){
        return locationService.updateCity(locationId, cityName);
    }


    @PostMapping("location/id/{locationId}/update-model")
    public Location updateLocation(@PathVariable Long locationId, @RequestBody LocationDto locationDto){
        return locationService.updateLocation(locationId, locationDto);
    }
}
