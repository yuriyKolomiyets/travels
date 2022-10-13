package com.example.travelservice.services;

import com.example.travelservice.model.Location;
import com.example.travelservice.model.PersonalInfo;

import java.util.Set;

public interface LocationService {
    Location saveLocation(Location location);

    Location findById(Long id);

}
