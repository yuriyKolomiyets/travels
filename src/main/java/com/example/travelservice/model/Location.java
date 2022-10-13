package com.example.travelservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return cityName.equals(location.cityName) && countryName.equals(location.countryName)
                && hotelName.equals(location.hotelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName, countryName, hotelName);
    }
}
