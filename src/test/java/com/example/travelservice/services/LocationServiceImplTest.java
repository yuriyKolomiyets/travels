package com.example.travelservice.services;

import com.example.travelservice.dto.LocationDto;
import com.example.travelservice.dtoconverters.LocationConverter;
import com.example.travelservice.exeptions.NotFoundException;
import com.example.travelservice.model.Location;
import com.example.travelservice.repositories.LocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class LocationServiceImplTest {

    LocationService locationService;

    @Mock
    LocationRepository locationRepository;

    @Mock
    LocationConverter locationConverter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        locationService = new LocationServiceImpl(locationRepository, locationConverter);

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

    @Test
    void updateLocation() {

        LocationDto locationDto = new LocationDto();
        Location locationExists = new Location();
        locationExists.setCityName("cityName");
        locationExists.setCountryName("country");
        locationExists.setHotelName("hotel");

        ArgumentCaptor<Location> argumentCaptor = ArgumentCaptor.forClass(Location.class);

        when(locationConverter.convert(locationDto)).thenReturn(locationExists);
        when(locationRepository.findById(1L)).thenReturn(Optional.of(locationExists));
        when(locationRepository.findById(2L)).thenReturn(Optional.empty());
        when(locationRepository.save(any())).thenReturn(locationExists);

        assertEquals(locationService.updateLocation(1L, locationDto), locationExists);
        verify(locationRepository, times(1)).save(argumentCaptor.capture());
        Location value = argumentCaptor.getValue();

        assertEquals(1L, value.getId());
        assertEquals("cityName", value.getCityName());
        assertEquals("country", value.getCountryName());
        assertEquals("hotel", value.getHotelName());

        assertThrows(NotFoundException.class, () -> locationService.updateLocation(2L, locationDto));
    }
}