package com.example.travelservice.dtoconverters;

import com.example.travelservice.dto.TripDto;
import com.example.travelservice.model.Location;
import com.example.travelservice.model.Trip;
import com.example.travelservice.repositories.TravelerRepository;
import com.example.travelservice.services.LocationService;
import com.example.travelservice.services.TripService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TripConverterTest {

    TripConverter tripConverter;

    public static final Date START = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
    public static final Date END = new GregorianCalendar(2014, Calendar.FEBRUARY, 14).getTime();

    @Mock
    TravelerRepository travelerRepository;

    @Mock
    LocationService locationService;

    @Mock
    TripService tripService;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tripConverter = new TripConverter(locationService);
    }

    @Test
    void convert() {
        //given
        TripDto tripDto = new TripDto();
        tripDto.setStartDate(START);
        tripDto.setEndDate(END);
        tripDto.setMeal("ALL");

        Location location = new Location();
        location.setId(1L);

        //when
        when(locationService.findById(1L)).thenReturn(location);

        Trip trip = tripConverter.convertTripDtoToTrip(tripDto);

        //then
        assertEquals(START, trip.getStartDate());
        assertEquals(END, trip.getEndDate());
    }
}