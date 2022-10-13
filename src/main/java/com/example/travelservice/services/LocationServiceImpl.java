package com.example.travelservice.services;

import com.example.travelservice.exeptions.ExistsException;
import com.example.travelservice.model.Location;
import com.example.travelservice.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location saveLocation(Location location) {

        if (!StreamSupport.stream(locationRepository.findAll().spliterator(), false)
                .anyMatch(location::equals)) {
            return locationRepository.save(location);

        } else throw new ExistsException("Location already exists");
    }

    @Override
    public Location findById(Long id) {
        return locationRepository.findById(id).orElseThrow();
    }


}
