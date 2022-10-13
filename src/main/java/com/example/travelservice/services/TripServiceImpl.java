package com.example.travelservice.services;

import com.example.travelservice.exeptions.ExistsException;
import com.example.travelservice.exeptions.NotFoundException;
import com.example.travelservice.model.Trip;
import com.example.travelservice.repositories.TripRepositories;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepositories tripRepositories;

    public TripServiceImpl(TripRepositories tripRepositories) {
        this.tripRepositories = tripRepositories;
    }

    @Override
    public Set<Trip> getTrips() {
        Set<Trip> tripSet = new HashSet<>();
        tripRepositories.findAll().iterator().forEachRemaining(tripSet::add);
        return tripSet;
    }

    @Override
    public Trip findById(Long l) {
        Optional<Trip> tripOptional = tripRepositories.findById(l);

        if (!tripOptional.isPresent()) {
            throw new NotFoundException("Trip Not Found. For ID value: " + l.toString() );
        }

        return tripOptional.get();
    }

    @Override
    public Trip saveTrip(Trip trip) {

        if (!getTrips().contains(trip)) {
            Trip save = tripRepositories.save(trip);
            //I am not returning save cause List of travelers throw exception
            //todo find out what should be returned in JSON
            Trip returnTrip = new Trip(save.getStartDate(),save.getEndDate(),save.getLocation(),save.getMeal());
            return returnTrip;

        } else throw new ExistsException("Trip already exists");

    }

    @Override
    public void deleteById(Long idToDelete) {
        tripRepositories.deleteById(idToDelete);
    }
}
