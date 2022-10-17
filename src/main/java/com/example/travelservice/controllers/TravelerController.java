package com.example.travelservice.controllers;

import com.example.travelservice.dto.LocationDto;
import com.example.travelservice.dto.TravelerDto;
import com.example.travelservice.dtoconverters.TravelerConverter;
import com.example.travelservice.model.Location;
import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.model.Traveler;
import com.example.travelservice.services.PersonalInfoService;
import com.example.travelservice.services.TravelerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TravelerController {

    private final PersonalInfoService personalInfoService;
    private final TravelerService travelerService;
    private final TravelerConverter travelerConverter;

    @PostMapping(value = "/traveler/create")
    public Traveler createTraveler(@RequestBody TravelerDto travelerDto) {

        PersonalInfo personalInfo = travelerConverter.convertPersonalInfo(travelerDto);
        personalInfoService.createPersonalInfo(personalInfo);

        Traveler traveler = travelerConverter.convertTraveler(travelerDto);
        return travelerService.createTraveler(traveler);
    }

    @PutMapping("traveler/id/{id}/update")
    public Traveler updateEmail(@PathVariable Long id, @RequestBody String email){
        return personalInfoService.updateEmail(id, email);
    }

    @PutMapping("traveler/id/{id}/update-model")
    public Traveler updateEmail(@PathVariable Long id, @RequestBody TravelerDto travelerDto){
        PersonalInfo personalInfo = travelerConverter.convertPersonalInfo(travelerDto);
        personalInfoService.updatePersonalInfo(id, personalInfo);

        Traveler traveler = travelerConverter.convertTraveler(travelerDto);
        return travelerService.updateTraveler(id, traveler);
    }
}
