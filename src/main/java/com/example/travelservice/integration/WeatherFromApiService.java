package com.example.travelservice.integration;

import com.example.travelservice.dto.WeatherDto;
import com.example.travelservice.model.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherFromApiService {

    @Value("${rest.base.path}")
    private String host;
    private final RestTemplate restTemplate = new RestTemplate();

    public List<WeatherDto> getWeatherByLatitudeAndLongitude(Location location) {
        WeatherDto[] forObject = restTemplate.getForObject(
                urlBuilder(location), WeatherDto[].class);
        return Arrays.asList(forObject);
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
