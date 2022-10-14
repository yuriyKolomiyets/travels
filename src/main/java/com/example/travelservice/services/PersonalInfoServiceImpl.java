package com.example.travelservice.services;

import com.example.travelservice.dto.TravelerDto;
import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.repositories.PersonalInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

    private final PersonalInfoRepository personalInfoRepository;

    public PersonalInfoServiceImpl(PersonalInfoRepository personalInfoRepository) {
        this.personalInfoRepository = personalInfoRepository;
    }

    @Override
    public PersonalInfo createPersonalInfo(PersonalInfo source) {
        if(personalInfoNotExists(source)){
            return personalInfoRepository.save(source);
        }
        return source;
    }


    @Override
    public PersonalInfo findById(Long id) {
        return personalInfoRepository.findById(id).orElseThrow();
    }

    @Override
    public Long findId(TravelerDto source) {

        PersonalInfo personalInfo = personalInfoRepository.findByEmailIs(source.getEmail()).get(0);
        return personalInfo.getId();
    }

    public boolean personalInfoNotExists(PersonalInfo source) {
        return personalInfoRepository.findByEmailIs(source.getEmail()).isEmpty();
    }
}
