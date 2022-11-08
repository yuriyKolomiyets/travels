package com.example.travelservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherRequest {
    private Double latitude;
    private Double longitude;
    private Long tripId;
}