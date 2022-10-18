package com.example.travelservice.services;

import com.example.travelservice.dto.TravelerDto;
import com.example.travelservice.exeptions.NotFoundException;
import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.model.Traveler;
import com.example.travelservice.repositories.PersonalInfoRepository;
import com.example.travelservice.repositories.TravelerRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

    private final PersonalInfoRepository personalInfoRepository;
    private final TravelerRepository travelerRepository;

    public PersonalInfoServiceImpl(PersonalInfoRepository personalInfoRepository, TravelerRepository travelerRepository) {
        this.personalInfoRepository = personalInfoRepository;
        this.travelerRepository = travelerRepository;
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

    @Override
    public PersonalInfo updatePersonalInfo(Long id, PersonalInfo personalInfo) {

        Traveler traveler = travelerRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Traveler Not Found. For ID value: " + id.toString() ));
        Long personalInfoId = traveler.getPersonalInfo().getId();
        personalInfo.setId(personalInfoId);
        return personalInfoRepository.save(personalInfo);
    }
}
