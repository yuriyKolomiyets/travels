package com.example.travelservice.services;

import com.example.travelservice.dto.LocationDto;
import com.example.travelservice.dtoconverters.LocationConverter;
import com.example.travelservice.exeptions.EntityAlreadyExistsException;
import com.example.travelservice.exeptions.NotFoundException;
import com.example.travelservice.model.Location;
import com.example.travelservice.repositories.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationConverter locationConverter;

    public LocationServiceImpl(LocationRepository locationRepository, LocationConverter locationConverter) {
        this.locationRepository = locationRepository;

        this.locationConverter = locationConverter;
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
    public Location findById(Long locationId) {
        return locationRepository.findById(locationId).orElseThrow(() ->
                new NotFoundException("Location with id" + locationId.toString() + " not found"));
    }

    @Override
    public Location updateLocation(Long locationId, LocationDto locationDto) {
        Location location = locationConverter.convert(locationDto);
        location.setId(locationId);
        if (locationRepository.findById(locationId).isEmpty()) {
            throw new NotFoundException("Location with id" + locationId.toString() + " not found");
        } else {
            return locationRepository.save(location);
        }
    }

    public boolean locationNotExists(Location source) {
        return locationRepository.findByCityNameAndCountryNameAndHotelName(source.getCityName(),
                source.getCountryName(), source.getHotelName()).isEmpty();
    }

}
