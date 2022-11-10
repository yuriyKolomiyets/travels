package com.example.travelservice.integration;

import com.example.travelservice.dto.WeatherDto;
import com.example.travelservice.dto.WeatherRequest;
import com.example.travelservice.dtoconverters.TripConverter;
import com.example.travelservice.dtoconverters.WeatherResponse;
import com.example.travelservice.model.Trip;
import com.example.travelservice.springevents.TripSpringEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@ConditionalOnProperty(value="rest.enabled", havingValue = "false", matchIfMissing = false)
public class WeatherFromRabbitMQService implements WeatherIntegrationService{

    private final WeatherChannels weatherChannels;
    private final TripConverter tripConverter;
    private final ApplicationEventPublisher applicationEventPublisher;


    @Override
    public void sendRequestToApi(Trip trip) {
        sendWeatherRequest(tripConverter.convertTripToWeatherRequest(trip));
    }

    @StreamListener(WeatherChannels.WEATHER_RESPONSE_INPUT_CHANNEL)
    public void listenWeatherResponse(WeatherResponse weatherResponses) {
        log.info("Got response from Rabbit {}", weatherResponses);
        publishCustomEvent(weatherResponses.getTripId(), weatherResponses.getWeatherDtoList());
    }

    @Override
    public void publishCustomEvent(Long tripId, List<WeatherDto> weatherDtoList) {
        log.info("Publishing custom event. ");
        TripSpringEvent tripSpringEvent = new TripSpringEvent(this, tripId, weatherDtoList);
        applicationEventPublisher.publishEvent(tripSpringEvent);
    }

    public void sendWeatherRequest(WeatherRequest weatherRequest) {
        weatherChannels.weatherRequest().send(MessageBuilder.withPayload(weatherRequest).build());
        log.info("Weather requested through Rabbit{} ", weatherRequest);
    }
}
