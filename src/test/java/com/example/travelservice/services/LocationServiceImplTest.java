package com.example.travelservice.services;

import com.example.travelservice.model.Location;
import com.example.travelservice.repositories.LocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class LocationServiceImplTest {

    LocationService locationService;

    @Mock
    LocationRepository locationRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        locationService = new LocationServiceImpl(locationRepository);
    }

    @Test
    void createLocation() {
        Location location = new Location();
        when(locationRepository.findByCityNameAndCountryNameAndHotelName(anyString(), anyString(), anyString()))
                .thenReturn(new ArrayList<>());
        locationService.createLocation(location);
        verify(locationRepository, times(1)).save(any());

    }

    @Test
    void findById() {

        Optional<Location> locationOptional = Optional.of(new Location());

        when(locationRepository.findById(anyLong())).thenReturn(locationOptional);

        Location byId = locationService.findById(1L);
        verify(locationRepository, times(1)).findById(anyLong());
    }

}