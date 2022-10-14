package com.example.travelservice.controllers;

import com.example.travelservice.dto.TravelerDto;
import com.example.travelservice.dtoconverters.TravelerConverter;
import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.model.Traveler;
import com.example.travelservice.services.PersonalInfoService;
import com.example.travelservice.services.TravelerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TravelerController {

    private final PersonalInfoService personalInfoService;
    private final TravelerService travelerService;
    private final TravelerConverter travelerConverter;

    @PostMapping(value = "/create/traveler")
    public Traveler createTraveler(@RequestBody TravelerDto travelerDto) {

        PersonalInfo personalInfo = travelerConverter.convertPersonalInfo(travelerDto);
        personalInfoService.createPersonalInfo(personalInfo);

        Traveler traveler = travelerConverter.convertTraveler(travelerDto);
        return travelerService.createTraveler(traveler);
    }
}
