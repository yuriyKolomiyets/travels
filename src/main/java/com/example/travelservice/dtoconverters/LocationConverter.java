package com.example.travelservice.dtoconverters;

import com.example.travelservice.dto.LocationDto;
import com.example.travelservice.model.Location;
import org.springframework.stereotype.Component;


@Component
public class LocationConverter {

    public Location convert(LocationDto source) {
        if (source == null) {
            return null;
        }
        return new Location(source.getCityName(),source.getCountryName(),source.getHotelName(),
                source.getLatitude(),source.getLongitude());
    }

}
