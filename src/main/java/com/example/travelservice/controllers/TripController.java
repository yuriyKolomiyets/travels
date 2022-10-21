package com.example.travelservice.controllers;

import com.example.travelservice.dto.TripDto;
import com.example.travelservice.dto.WeatherDto;
import com.example.travelservice.dtoconverters.TripConverter;
import com.example.travelservice.model.Trip;
import com.example.travelservice.services.TripService;
import com.example.travelservice.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;
    private final TripConverter tripConverter;
    private final WeatherService weatherService;

    @PostMapping(value = "/trip/create")
    public Trip createTrip(@RequestBody TripDto tripDto) {
        return tripService.createTrip(tripConverter.convertTripDtoToTrip(tripDto));
    }

    @GetMapping(value = "/trip/show-weather")
    public List<WeatherDto> showTripWeather(@RequestBody TripDto tripDto) {
        return weatherService.getWeatherThroughRest(tripConverter.convertTripDtoToTrip(tripDto));
    }

    @PutMapping("trip/id/{id}/update")
    public Trip updateTrip(@PathVariable Long id, @RequestBody TripDto tripDto){
        return tripService.updateTrip (id, tripConverter.convertTripDtoToTrip(tripDto));
    }
}
