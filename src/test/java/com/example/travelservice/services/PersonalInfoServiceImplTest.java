package com.example.travelservice.services;

import com.example.travelservice.exeptions.NotFoundException;
import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.model.Traveler;
import com.example.travelservice.repositories.PersonalInfoRepository;
import com.example.travelservice.repositories.TravelerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class PersonalInfoServiceImplTest {

    PersonalInfoService personalInfoService;

    @Mock
    PersonalInfoRepository personalInfoRepository;

    @Mock
    TravelerRepository travelerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        personalInfoService = new PersonalInfoServiceImpl(personalInfoRepository, travelerRepository);
    }

    @Test
    void createPersonalInfo() {

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setEmail("test");
        personalInfo.setPhone("12344");

        when(personalInfoRepository.findByEmailIs(anyString())).thenReturn(new ArrayList<>());
        when(personalInfoRepository.save(any())).thenReturn(personalInfo);

        personalInfoService.createPersonalInfo(personalInfo);

        verify(personalInfoRepository, times(1)).save(any());

    }

    @Test
    void updatePersonalInfo() {

        Traveler traveler = new Traveler();
        PersonalInfo personalInfo = new PersonalInfo();
        traveler.setPersonalInfo(personalInfo);
        personalInfo.setEmail("email");
        personalInfo.setPhone("phone");
        personalInfo.setId(1L);

        ArgumentCaptor<PersonalInfo> argumentCaptor = ArgumentCaptor.forClass(PersonalInfo.class);

        when(travelerRepository.findById(1L)).thenReturn(Optional.of(traveler));
        when(personalInfoRepository.findById(2L)).thenReturn(Optional.empty());
        when(personalInfoRepository.save(any())).thenReturn(personalInfo);

        assertEquals(personalInfoService.updatePersonalInfo(1L, personalInfo), personalInfo);
        verify(personalInfoRepository, times(1)).save(argumentCaptor.capture());
        PersonalInfo value = argumentCaptor.getValue();

        assertEquals(1L, value.getId());
        assertEquals("email", value.getEmail());
        assertEquals("phone", value.getPhone());

        assertThrows(NotFoundException.class, () -> personalInfoService.updatePersonalInfo(2L, personalInfo));
    }
}