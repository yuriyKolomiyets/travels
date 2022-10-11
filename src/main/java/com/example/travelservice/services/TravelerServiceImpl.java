package com.example.travelservice.services;

import com.example.travelservice.exeptions.NotFoundException;
import com.example.travelservice.model.Traveler;
import com.example.travelservice.model.Trip;
import com.example.travelservice.repositories.TravelerRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TravelerServiceImpl implements TravelerService {

    private final TravelerRepository travelerRepository;

    public TravelerServiceImpl(TravelerRepository travelerRepository) {
        this.travelerRepository = travelerRepository;
    }

    @Override
    public Set<Traveler> getTravelers() {
        Set<Traveler> travelerSet = new HashSet<>();
        travelerRepository.findAll().iterator().forEachRemaining(travelerSet::add);
        return travelerSet;
    }

    @Override
    public Traveler findById(Long l) {
        Optional<Traveler> travelerOptional = travelerRepository.findById(l);

        if (!travelerOptional.isPresent()) {
            throw new NotFoundException("Treveler Not Found. For ID value: " + l.toString() );
        }

        return travelerOptional.get();
    }

    @Override
    public Traveler saveTraveler(Traveler traveler) {
        return travelerRepository.save(traveler);
    }

    @Override
    public void deleteById(Long idToDelete) {
        travelerRepository.deleteById(idToDelete);
    }
}
