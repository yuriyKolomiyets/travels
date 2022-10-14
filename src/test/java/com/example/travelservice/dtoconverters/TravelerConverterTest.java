package com.example.travelservice.dtoconverters;

import com.example.travelservice.dto.TravelerDto;
import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.model.Traveler;
import com.example.travelservice.services.PersonalInfoService;
import com.example.travelservice.services.TravelerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TravelerConverterTest {

    @Mock
    PersonalInfoService personalInfoService;

    @Mock
    TravelerService travelerService;

    TravelerConverter travelerConverter;

    private static final String EMAIL = "11@11";
    private static final Integer AGE = 11;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        travelerConverter = new TravelerConverter(personalInfoService,travelerService);

    }

    @Test
    void convertPersonalInfo() {
        TravelerDto travelerDto = new TravelerDto();
        travelerDto.setEmail(EMAIL);

        PersonalInfo personalInfo = travelerConverter.convertPersonalInfo(travelerDto);
        assertEquals(EMAIL, personalInfo.getEmail());

    }

    @Test
    void convertTraveler() {
        TravelerDto travelerDto = new TravelerDto();
        travelerDto.setAge(AGE);

        when(personalInfoService.findId(any())).thenReturn(1L);

        Traveler traveler = travelerConverter.convertTraveler(travelerDto);
        assertEquals(AGE, traveler.getAge());
    }
}