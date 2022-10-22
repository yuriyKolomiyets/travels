package com.example.travelservice.services;

import com.example.travelservice.dto.WeatherDto;
import com.example.travelservice.dto.WeatherRequest;
import com.example.travelservice.dtoconverters.WeatherResponse;
import com.example.travelservice.integration.WeatherChannels;
import com.example.travelservice.integration.WeatherFromApiService;
import com.example.travelservice.model.Trip;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private final WeatherFromApiService weatherFromApiService;
    private final WeatherChannels weatherChannels;

    @Override
    public List<WeatherDto> getWeatherThroughRest(Trip trip) {
        return weatherFromApiService.getWeatherByLatitudeAndLongitude(trip.getLocation());
    }

    @Override
    @StreamListener(WeatherChannels.WEATHER_RESPONSE_INPUT_CHANNEL)
    public void listenWeatherResponse(List<WeatherResponse> weatherResponses) {
        log.info("Got response for weatherApi {}", weatherResponses);
    }

    @Override
    public void sendWeatherRequest(WeatherRequest weatherRequest) {
        weatherChannels.weatherRequest().send(MessageBuilder.withPayload(weatherRequest).build());
        log.info("Weather requested {} ", weatherRequest);
    }
}
