package com.example.travelservice.dto;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class WeatherDto implements Serializable {
    private String date;
    private String time;
    private Double temperature;
    private Double rainProbability;
}
