package com.example.travelservice.repositories;

import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.model.Traveler;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TravelerRepository extends CrudRepository<Traveler, Long> {
    List <Traveler> findByIdIn (List<Long> idList);
    List<Traveler> findByFirstNameAndLastName (String firstName, String lastName);
}
