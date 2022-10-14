package com.example.travelservice.dtoconverters;

import com.example.travelservice.dto.LocationDto;
import com.example.travelservice.model.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationConverterTest {

    LocationConverter locationConverter;
    public static final String CITY = "Kyiv";
    public static final String COUNTRY = "Ukraine";

    @BeforeEach
    void setUp() {
        locationConverter = new LocationConverter();

    }

    @Test
    void convert() {
        //given
        LocationDto locationDto = new LocationDto();
        locationDto.setCityName(CITY);
        locationDto.setCountryName(COUNTRY);

        //when
        Location location = locationConverter.convert(locationDto);

        //then
        assertEquals(CITY, location.getCityName());
        assertEquals(COUNTRY, location.getCountryName());
    }
}