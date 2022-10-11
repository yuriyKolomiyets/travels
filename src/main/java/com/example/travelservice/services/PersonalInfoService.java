package com.example.travelservice.services;

import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.model.Traveler;

import java.util.Set;

public interface PersonalInfoService {

    PersonalInfo savePersonalInfo(PersonalInfo personalInfo);

    void deleteById(Long idToDelete);
}
