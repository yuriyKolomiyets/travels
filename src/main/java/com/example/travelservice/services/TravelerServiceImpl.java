package com.example.travelservice.services;

import com.example.travelservice.dto.TravelerDto;
import com.example.travelservice.exeptions.NotFoundException;
import com.example.travelservice.model.Traveler;
import com.example.travelservice.repositories.TravelerRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TravelerServiceImpl implements TravelerService {

    private final TravelerRepository travelerRepository;

    public TravelerServiceImpl(TravelerRepository travelerRepository) {
        this.travelerRepository = travelerRepository;
    }

    @Override
    public Traveler findById(Long l) {
        Optional<Traveler> travelerOptional = travelerRepository.findById(l);

        if (!travelerOptional.isPresent()) {
            throw new NotFoundException("Traveler Not Found. For ID value: " + l.toString() );
        }

        return travelerOptional.get();
    }

    @Override
    public Long findId(TravelerDto source) {
        Traveler traveler = travelerRepository
                .findByFirstNameAndLastName(source.getFirstName(),source.getLastName())
                .get(0);

        return traveler.getId();
    }

    @Override
    public Traveler createTraveler(Traveler traveler) {
        return travelerRepository.save(traveler);
    }

    @Override
    public Traveler updateTraveler(Long id, Traveler traveler) {
        traveler.setId(id);
        return travelerRepository.save(traveler);
    }


}
