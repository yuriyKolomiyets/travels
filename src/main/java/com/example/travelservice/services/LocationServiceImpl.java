package com.example.travelservice.services;

import com.example.travelservice.model.Location;
import com.example.travelservice.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

}
