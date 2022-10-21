package com.example.travelservice.services;

import com.example.travelservice.dto.WeatherDto;
import com.example.travelservice.dto.WeatherRequest;
import com.example.travelservice.model.Trip;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface WeatherService {
    List<WeatherDto> showTripWeather(Trip convert);

    void listenWeatherResponse(WeatherDto weatherDto);
    void sendWeatherRequest(WeatherRequest weatherRequest);
}
