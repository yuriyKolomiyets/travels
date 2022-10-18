package com.example.travelservice.services;

import com.example.travelservice.dto.LocationDto;
import com.example.travelservice.model.Location;

public interface LocationService {
    Location createLocation(Location location);

    Location findById(Long id);

    Location updateCity(Long locationId, String cityName);

    Location updateLocation(Long locationId, LocationDto locationDto);
}
