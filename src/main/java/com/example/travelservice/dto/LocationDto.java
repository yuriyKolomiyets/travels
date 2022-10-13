package com.example.travelservice.dto;

import com.example.travelservice.model.Location;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationDto {

    private String cityName;
    private String countryName;
    private String hotelName;
    private String latitude;
    private String longitude;

    public Location convertToLocation() {
        return new Location(cityName, countryName, hotelName, latitude, longitude);
    }
}
