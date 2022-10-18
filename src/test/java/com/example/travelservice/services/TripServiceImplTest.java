package com.example.travelservice.services;

import com.example.travelservice.exeptions.NotFoundException;
import com.example.travelservice.integration.WeatherFromApiService;
import com.example.travelservice.model.Location;
import com.example.travelservice.model.Meal;
import com.example.travelservice.model.Traveler;
import com.example.travelservice.model.Trip;
import com.example.travelservice.repositories.TripRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class TripServiceImplTest {

    @Mock
    TripRepository tripRepository;

    @Mock
    WeatherFromApiService weatherFromApiService;

    TripService tripService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tripService = new TripServiceImpl(tripRepository, weatherFromApiService);
    }

    @Test
    void updateTrip() {
        Trip trip = new Trip();
        Location location = new Location();
        trip.setLocation(location);
        trip.setMeal(Meal.ALL);

        when(tripRepository.findById(1L)).thenReturn(Optional.of(trip));
        when(tripRepository.findById(2L)).thenReturn(Optional.empty());
        when(tripRepository.save(any())).thenReturn(trip);

        ArgumentCaptor<Trip> argumentCaptor = ArgumentCaptor.forClass(Trip.class);

        assertEquals(tripService.updateTrip(1L, trip), trip);
        verify(tripRepository, times(1)).save(argumentCaptor.capture());
        Trip value = argumentCaptor.getValue();

        assertEquals(location, trip.getLocation());
        assertEquals(Meal.ALL, trip.getMeal());

        assertThrows(NotFoundException.class, () -> tripService.updateTrip(2L, trip));

    }
}