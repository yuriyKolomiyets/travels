package com.example.travelservice.services;

import com.example.travelservice.dto.TravelerDto;
import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.model.Traveler;


public interface PersonalInfoService {

    PersonalInfo createPersonalInfo(PersonalInfo personalInfo);

    PersonalInfo findById (Long id);

    Long findId(TravelerDto source);

    Traveler updateEmail(Long id, String email);

    PersonalInfo updatePersonalInfo(Long id, PersonalInfo personalInfo);
}
