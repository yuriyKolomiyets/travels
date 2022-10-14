package com.example.travelservice.controllers;

import com.example.travelservice.dtoconverters.TravelerConverter;
import com.example.travelservice.model.Traveler;
import com.example.travelservice.model.Trip;
import com.example.travelservice.services.PersonalInfoService;
import com.example.travelservice.services.TravelerService;
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

class TravelerControllerTest {

    MockMvc mockMvc;

    @Mock
    TravelerService travelerService;

    @Mock
    PersonalInfoService personalInfoService;

    @Mock
    TravelerConverter travelerConverter;

    TravelerController travelerController;

    public static final Long TRAVELER_ID = 1L;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        travelerController = new TravelerController(personalInfoService,travelerService, travelerConverter);
        mockMvc = MockMvcBuilders.standaloneSetup(travelerController)
                .build();
    }

    @Test
    void createTraveler() throws Exception {
        Traveler traveler = new Traveler();
        traveler.setId(TRAVELER_ID);

        Gson gson = new Gson();
        String json = gson.toJson(traveler);

        when(travelerService.createTraveler(any())).thenReturn(traveler);
        mockMvc.perform(post("/traveler/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(TRAVELER_ID))
                .andReturn();

    }
}