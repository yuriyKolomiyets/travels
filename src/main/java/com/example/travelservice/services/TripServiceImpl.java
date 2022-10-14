package com.example.travelservice.services;

import com.example.travelservice.exeptions.EntityAlreadyExistsException;
import com.example.travelservice.exeptions.NotFoundException;
import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.model.Trip;
import com.example.travelservice.repositories.TripRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }


    @Override
    public Trip findById(Long l) {
        Optional<Trip> tripOptional = tripRepository.findById(l);

        if (!tripOptional.isPresent()) {
            throw new NotFoundException("Trip Not Found. For ID value: " + l.toString() );
        }

        return tripOptional.get();
    }

    @Override
    public Trip createTrip(Trip trip) {
            return tripRepository.save(trip);
    }

}
