package com.example.travelservice.repositories;

import com.example.travelservice.model.Location;
import com.example.travelservice.model.Trip;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

public interface TripRepository extends CrudRepository<Trip, Long> {
    List<Trip> findByStartDateAndLocation(Date startDate, Location location);
}
