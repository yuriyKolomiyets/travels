package com.example.travelservice.controllers;

import com.example.travelservice.dtoconverters.TripConverter;
import com.example.travelservice.model.Location;
import com.example.travelservice.model.Trip;
import com.example.travelservice.services.TripService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TripControllerTest {

    MockMvc mockMvc;

    @Mock
    TripService tripService;

    @Mock
    TripConverter tripConverter;

    TripController tripController;
    public static final Long TRIP_ID = 1L;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        tripController = new TripController(tripService, tripConverter);
        mockMvc = MockMvcBuilders.standaloneSetup(tripController)
                .build();

    }

    @Test
    void createTrip() throws Exception {

        Trip trip = new Trip();
        trip.setId(TRIP_ID);

        Gson gson = new Gson();
        String json = gson.toJson(trip);

        when(tripService.createTrip(any())).thenReturn(trip);
        mockMvc.perform(post("/trip/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(TRIP_ID))
                .andReturn();
    }
}