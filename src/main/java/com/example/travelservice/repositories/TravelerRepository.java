package com.example.travelservice.repositories;

import com.example.travelservice.model.Traveler;
import org.springframework.data.repository.CrudRepository;

public interface TravelerRepository extends CrudRepository<Traveler, Long> {
}
