package com.example.travelservice.services;

import com.example.travelservice.exeptions.NotFoundException;
import com.example.travelservice.model.Traveler;
import com.example.travelservice.repositories.TravelerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TravelerServiceImplTest {

    @Mock
    TravelerRepository travelerRepository;

    TravelerService travelerService;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        travelerService = new TravelerServiceImpl(travelerRepository);
    }

    @Test
    void updateTraveler() {
        Traveler traveler = new Traveler();
        traveler.setAge(10);
        traveler.setFirstName("nom");
        traveler.setLastName("prenom");

        when(travelerRepository.findById(1L)).thenReturn(Optional.of(traveler));
        when(travelerRepository.findById(2L)).thenReturn(Optional.empty());
        when(travelerRepository.save(any())).thenReturn(traveler);

        ArgumentCaptor<Traveler> argumentCaptor = ArgumentCaptor.forClass(Traveler.class);

        assertEquals(travelerService.updateTraveler(1L, traveler), traveler);

        verify(travelerRepository, times(1)).save(argumentCaptor.capture());
        Traveler value = argumentCaptor.getValue();

        assertEquals(1L, value.getId());
        assertEquals("nom", value.getFirstName());
        assertEquals("prenom", value.getLastName());

        assertThrows(NotFoundException.class, () -> travelerService.updateTraveler(2L, traveler));

    }
}