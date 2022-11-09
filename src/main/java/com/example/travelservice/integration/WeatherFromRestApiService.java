package com.example.travelservice.integration;

import com.example.travelservice.dto.WeatherDto;
import com.example.travelservice.model.Location;
import com.example.travelservice.model.Trip;
import com.example.travelservice.springevents.TripSpringEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@ConditionalOnProperty(value="rest.enabled", havingValue = "true", matchIfMissing = true)
public class WeatherFromRestApiService implements WeatherIntegrationService {

    @Value("${rest.base.path}")
    private String host;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ApplicationEventPublisher applicationEventPublisher;


    @Async
    public void sendRequestToApi(Trip trip) {
        Location location = trip.getLocation();
        WeatherDto[] weatherDtosArray = restTemplate.getForObject(
                urlBuilder(location), WeatherDto[].class);

        List<WeatherDto> weatherDtos = Arrays.asList(Objects.requireNonNull(weatherDtosArray));

        publishCustomEvent(trip.getId(), weatherDtos);
    }

    @Override
    public void publishCustomEvent(Long tripId, List<WeatherDto> weatherDtoList) {
        TripSpringEvent tripSpringEvent = new TripSpringEvent(this, tripId, weatherDtoList);
        applicationEventPublisher.publishEvent(tripSpringEvent);
    }

    private String urlBuilder(Location location) {
        String s = host +
                "latitude/" +
                location.getLatitude() + "/longitude/" +
                location.getLongitude();
        System.out.println(s);

        return s;
    }
}
