package com.example.travelservice.repositories;

import com.example.travelservice.model.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepositories extends CrudRepository<Trip, Long> {
}
