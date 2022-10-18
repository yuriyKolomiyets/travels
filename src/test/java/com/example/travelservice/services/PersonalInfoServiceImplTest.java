package com.example.travelservice.services;

import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.repositories.PersonalInfoRepository;
import com.example.travelservice.repositories.TravelerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

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
}