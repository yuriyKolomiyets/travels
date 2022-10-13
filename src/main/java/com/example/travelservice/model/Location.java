package com.example.travelservice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id", "latitude", "longitude"})

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 255)
    private String cityName;

    @Size(min = 3, max = 255)
    private String countryName;

    @Size(min = 3, max = 255)
    private String hotelName;

    @Size(min = 3, max = 255)
    private String latitude;

    @Size(min = 3, max = 255)
    private String longitude;

    public Location(String cityName, String countryName, String hotelName, String latitude, String longitude) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.hotelName = hotelName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
