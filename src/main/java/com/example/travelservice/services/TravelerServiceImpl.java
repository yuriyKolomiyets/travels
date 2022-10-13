package com.example.travelservice.services;

import com.example.travelservice.dto.TravelerDto;
import com.example.travelservice.exeptions.NotFoundException;
import com.example.travelservice.model.PersonalInfo;
import com.example.travelservice.model.Traveler;
import com.example.travelservice.model.Trip;
import com.example.travelservice.repositories.TravelerRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.StreamSupport;

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
    public Long findId(TravelerDto source) {
        Traveler traveler = StreamSupport.stream(travelerRepository.findAll().
                        spliterator(), false)
                .filter(p -> (
                        p.getLastName().equals(source.getLastName())
                                && p.getFirstName().equals(source.getFirstName())))
                .findFirst().orElseThrow();
        return traveler.getId();
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
