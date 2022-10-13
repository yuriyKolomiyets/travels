package com.example.travelservice.dto;

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


}
