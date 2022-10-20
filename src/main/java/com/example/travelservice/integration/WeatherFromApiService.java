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

    @Value("${rest.base.path1}")
    private String hostRabbit;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<WeatherDto> getWeatherByLatitudeAndLongitude(Location location) {
        WeatherDto[] forObject = restTemplate.getForObject(
                urlBuilder(location), WeatherDto[].class);
        return Arrays.asList(forObject);
    }

    //todo refactoring to avoid code duplicates

    public List<WeatherDto> getWeatherByLatitudeAndLongitudeWithRabbit (Location location) {

        // call sendWeatherWithRabbit on weather service?

        return null;
    }

    private String urlBuilder(Location location) {
        String s = host +
                "latitude/" +
                location.getLatitude() + "/longitude/" +
                location.getLongitude();
        System.out.println(s);

        return s;
    }

    //todo refactoring to avoid code duplicates

    private String urlBuilderRabbit (Location location) {
        String s = hostRabbit +
                "latitude/" +
                location.getLatitude() + "/longitude/" +
                location.getLongitude();
        System.out.println(s);

        return s;
    }
}
