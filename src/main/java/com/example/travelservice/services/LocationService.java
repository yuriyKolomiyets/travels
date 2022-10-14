package com.example.travelservice.services;

import com.example.travelservice.model.Location;

public interface LocationService {
    Location createLocation(Location location);

    Location findById(Long id);

}
