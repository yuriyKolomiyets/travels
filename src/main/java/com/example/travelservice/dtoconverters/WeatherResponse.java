package com.example.travelservice.dtoconverters;

import com.example.travelservice.dto.WeatherDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherResponse {

    private List<WeatherDto> weatherDtoList;
    private Long tripId;

}
