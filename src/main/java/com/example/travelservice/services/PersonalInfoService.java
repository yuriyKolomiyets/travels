package com.example.travelservice.services;

import com.example.travelservice.dto.TravelerDto;
import com.example.travelservice.model.PersonalInfo;


public interface PersonalInfoService {

    PersonalInfo savePersonalInfo(PersonalInfo personalInfo);

    void deleteById(Long idToDelete);

    PersonalInfo findById (Long id);

    Long findId(TravelerDto source);
}
