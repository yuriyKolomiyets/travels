package com.example.travelservice.services;

import com.example.travelservice.dto.WeatherDto;
import com.example.travelservice.dto.WeatherRequest;
import com.example.travelservice.dtoconverters.WeatherResponse;
import com.example.travelservice.integration.WeatherChannels;
import com.example.travelservice.integration.WeatherFromApiService;
import com.example.travelservice.model.Trip;
import com.example.travelservice.springevents.TripSpringEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private final WeatherFromApiService weatherFromApiService;
    private final WeatherChannels weatherChannels;
    private final ApplicationEventPublisher applicationEventPublisher;

    public WeatherServiceImpl(WeatherFromApiService weatherFromApiService, WeatherChannels weatherChannels, ApplicationEventPublisher applicationEventPublisher) {
        this.weatherFromApiService = weatherFromApiService;
        this.weatherChannels = weatherChannels;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<WeatherDto> getWeatherThroughRest(Trip trip) {
        return weatherFromApiService.getWeatherByLatitudeAndLongitude(trip.getLocation());
    }

    @Override
    @StreamListener(WeatherChannels.WEATHER_RESPONSE_INPUT_CHANNEL)
    public void listenWeatherResponse(WeatherResponse weatherResponses) {
        log.info("Got response for weatherApi {}", weatherResponses);
        publishCustomEvent(weatherResponses.getTripId(), weatherResponses.getWeatherDtoList());
    }

    public void publishCustomEvent(Long tripId, List<WeatherDto> weatherDtoList) {
        log.info("Publishing custom event. ");
        TripSpringEvent tripSpringEvent = new TripSpringEvent(this, tripId, weatherDtoList);
        applicationEventPublisher.publishEvent(tripSpringEvent);
    }

    @Override
    public void sendWeatherRequest(WeatherRequest weatherRequest) {
        weatherChannels.weatherRequest().send(MessageBuilder.withPayload(weatherRequest).build());
        log.info("Weather requested {} ", weatherRequest);
    }
}
