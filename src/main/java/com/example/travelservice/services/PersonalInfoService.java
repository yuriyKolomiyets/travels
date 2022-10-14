package com.example.travelservice.services;

import com.example.travelservice.dto.TravelerDto;
import com.example.travelservice.model.PersonalInfo;


public interface PersonalInfoService {

    PersonalInfo createPersonalInfo(PersonalInfo personalInfo);

    PersonalInfo findById (Long id);

    Long findId(TravelerDto source);
}
