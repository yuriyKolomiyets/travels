package com.example.travelservice.services;

import com.example.travelservice.dto.WeatherDto;
import com.example.travelservice.exeptions.NotFoundException;
import com.example.travelservice.integration.WeatherFromApiService;
import com.example.travelservice.model.Trip;
import com.example.travelservice.repositories.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final WeatherFromApiService weatherFromApiService;

    public TripServiceImpl(TripRepository tripRepository, WeatherFromApiService weatherFromApiService) {
        this.tripRepository = tripRepository;
        this.weatherFromApiService = weatherFromApiService;
    }

    @Override
    public Trip findById(Long l) {

        Optional<Trip> tripOptional = tripRepository.findById(l);

        if (!tripOptional.isPresent()) {
            throw new NotFoundException("Trip Not Found. For ID value: " + l.toString());
        }

        return tripOptional.get();
    }

    @Override
    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public List<WeatherDto> showTripWeather(Trip trip) {
        return weatherFromApiService.getWeatherByLatitudeAndLongitude(trip.getLocation());

    }

    @Override
    public Trip updateTrip(Long id, Trip trip) {

        trip.setId(id);

        if (tripRepository.findById(id).isPresent()) {
            return tripRepository.save(trip);
        } else {
            return createTrip(trip);
        }
    }
}
