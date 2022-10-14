package com.example.travelservice.controllers;

import com.example.travelservice.dtoconverters.LocationConverter;
import com.example.travelservice.model.Location;
import com.example.travelservice.services.LocationService;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class LocationControllerTest {

    @Mock
    LocationService locationService;

    @Mock
    LocationConverter locationConverter;

    LocationController locationController;

    MockMvc mockMvc;

    public static final Long LOCATION_ID = 1L;


    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        locationController = new LocationController(locationService, locationConverter);
        mockMvc = MockMvcBuilders.standaloneSetup(locationController)
                .build();
    }

    @Test
    void createLocation() throws Exception {
        Location location = new Location();
        location.setId(LOCATION_ID);

        Gson gson = new Gson();
        String json = gson.toJson(location);

        when(locationService.createLocation(any())).thenReturn(location);
        mockMvc.perform(post("/location/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(LOCATION_ID))
                .andReturn();

    }
}