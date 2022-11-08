package com.example.travelservice.springevents;

import com.example.travelservice.dto.WeatherDto;
import org.springframework.context.ApplicationEvent;

import java.util.List;

public class TripSpringEvent extends ApplicationEvent {

    private Long tripId;
    private List<WeatherDto> weatherDtoList;


    public TripSpringEvent(Object source, Long tripId, List<WeatherDto> weatherDtoList) {
        super(source);
        this.tripId = tripId;
        this.weatherDtoList = weatherDtoList;
    }

    public Long getTripId() {
        return tripId;
    }

    public List<WeatherDto> getWeatherDtoList() {
        return weatherDtoList;
    }
}
