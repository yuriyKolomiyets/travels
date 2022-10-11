package com.example.travelservice.services;

import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.repositories.PersonalInfoRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

    private final PersonalInfoRepository personalInfoRepository;

    public PersonalInfoServiceImpl(PersonalInfoRepository personalInfoRepository) {
        this.personalInfoRepository = personalInfoRepository;
    }

    @Override
    public PersonalInfo savePersonalInfo(PersonalInfo personalInfo) {
        return personalInfoRepository.save(personalInfo);
    }

    @Override
    public void deleteById(Long idToDelete) {
        personalInfoRepository.deleteById(idToDelete);
    }
}
