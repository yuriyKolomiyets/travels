package com.example.travelservice.services;

import com.example.travelservice.exeptions.EntityAlreadyExistsException;
import com.example.travelservice.model.Location;
import com.example.travelservice.model.PersonalInfo;
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
    public Location createLocation(Location location) {

        if (locationNotExists(location)) {
            return locationRepository.save(location);

        } else {
            throw new EntityAlreadyExistsException("Location already exists");
        }
    }

    @Override
    public Location findById(Long id) {
        return locationRepository.findById(id).orElseThrow();
    }

    public boolean locationNotExists(Location source) {
        return locationRepository.findByCityNameAndCountryNameAndHotelName(source.getCityName(),
                source.getCountryName(), source.getHotelName()).isEmpty();
    }


}
