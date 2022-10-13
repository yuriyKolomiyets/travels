package com.example.travelservice.dto;

import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationRequestModel {

    private String cityName;
    private String countryName;
    private String hotelName;
    private String latitude;
    private String longitude;

}
