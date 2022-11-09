package com.example.travelservice.integration;

import com.example.travelservice.dto.WeatherDto;
import com.example.travelservice.model.Trip;

import java.util.List;

public interface WeatherIntegrationService {

    void sendRequestToApi(Trip trip);
    void publishCustomEvent(Long tripId, List<WeatherDto> weatherDtoList);
}
