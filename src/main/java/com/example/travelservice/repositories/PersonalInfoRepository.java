package com.example.travelservice.repositories;

import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.model.Traveler;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonalInfoRepository extends CrudRepository<PersonalInfo, Long> {
    List<PersonalInfo> findByEmailIs (String email);
}
