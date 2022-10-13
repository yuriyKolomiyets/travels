package com.example.travelservice.services;

import com.example.travelservice.dto.TravelerDto;
import com.example.travelservice.exeptions.NotFoundException;
import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.repositories.PersonalInfoRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.StreamSupport;

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

    @Override
    public PersonalInfo findById(Long id) {
        return personalInfoRepository.findById(id).orElseThrow();
    }

    @Override
    public Long findId(TravelerDto source) {

        PersonalInfo personalInfo = StreamSupport.stream(personalInfoRepository.findAll().
                        spliterator(), false).filter(p -> p.getEmail().equals(source.getEmail()))
                .findFirst().orElseThrow();
        return personalInfo.getId();
    }
}
