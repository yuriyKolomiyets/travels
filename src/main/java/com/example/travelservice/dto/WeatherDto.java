package com.example.travelservice.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class WeatherDto {
    private String date;
    private String time;
    private Double temperature;
    private Double rainProbability;
}
