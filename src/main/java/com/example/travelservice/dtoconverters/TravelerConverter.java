package com.example.travelservice.dtoconverters;

import com.example.travelservice.dto.TravelerDto;
import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.model.Traveler;
import com.example.travelservice.services.PersonalInfoService;
import com.example.travelservice.services.TravelerService;
import org.springframework.stereotype.Component;

@Component
public class TravelerConverter {

    private final PersonalInfoService personalInfoService;
    private final TravelerService travelerService;

    public TravelerConverter(PersonalInfoService personalInfoService, TravelerService travelerService) {
        this.personalInfoService = personalInfoService;
        this.travelerService = travelerService;
    }

    public PersonalInfo convertPersonalInfo(TravelerDto source) {
        if (source == null) {
            return null;
        }
        return new PersonalInfo(source.getEmail(), source.getPhone(), source.getAddress());
    }

    public Traveler convertTraveler(TravelerDto source) {
        if (source == null) {
            return null;
        }
        Long personInfoId = personalInfoService.findId(source);
        PersonalInfo personalInfo = personalInfoService.findById(personInfoId);

        return new Traveler(source.getFirstName(), source.getLastName(), source.getAge(), personalInfo);
    }
}
