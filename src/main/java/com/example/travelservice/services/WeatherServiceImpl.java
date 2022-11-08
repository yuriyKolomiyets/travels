package com.example.travelservice.services;

import com.example.travelservice.dto.WeatherDto;
import com.example.travelservice.integration.WeatherIntegrationService;
import com.example.travelservice.model.Trip;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherIntegrationService weatherIntegrationService;


    @Override
    public List<WeatherDto> getWeatherFromApi(Trip trip) {
        log.info("Weather requested through Rest ");
        return weatherIntegrationService.getWeatherFromApi(trip);
    }
}
