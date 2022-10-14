package com.example.travelservice.services;

import com.example.travelservice.dto.TravelerDto;
import com.example.travelservice.model.Traveler;

import java.util.Set;

public interface TravelerService {
    Traveler findById(Long l);

    Long findId(TravelerDto source);

    Traveler createTraveler(Traveler traveler);}
