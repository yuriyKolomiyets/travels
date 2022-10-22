package com.example.travelservice.services;

import com.example.travelservice.dto.WeatherDto;
import com.example.travelservice.dto.WeatherRequest;
import com.example.travelservice.dtoconverters.WeatherResponse;
import com.example.travelservice.model.Trip;

import java.util.List;

public interface WeatherService {
    List<WeatherDto> getWeatherThroughRest(Trip convert);

    void listenWeatherResponse(WeatherResponse weatherResponses);
    void sendWeatherRequest(WeatherRequest weatherRequest);
}
