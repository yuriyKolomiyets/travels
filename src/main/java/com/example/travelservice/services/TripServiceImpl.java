package com.example.travelservice.services;
import com.example.travelservice.dto.WeatherDto;
import com.example.travelservice.dtoconverters.TripConverter;
import com.example.travelservice.exeptions.NotFoundException;
import com.example.travelservice.model.Trip;
import com.example.travelservice.repositories.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final WeatherService weatherService;
    private final TripConverter tripConverter;

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
        Trip save = tripRepository.save(trip);
        weatherService.sendWeatherRequest(tripConverter.convertTripToWeatherRequest(trip, trip.getId()));
        return save;
    }

    @Override
    public Trip updateTrip(Long id, Trip trip) {

        trip.setId(id);

        if (tripRepository.findById(id).isPresent()) {
            return tripRepository.save(trip);
        } else {
            throw new NotFoundException("Trip Not Found. For ID value: " + id.toString());
        }
    }

    @Override
    public Long findId(Trip source) {
        Trip trip = tripRepository.findByStartDateAndLocation(source.getStartDate(), source.getLocation()).get(0);
        return trip.getId();
    }

    @Override
    public List<WeatherDto> saveWeather(Long tripId, List<WeatherDto> weatherDtoList) {
        Trip trip = findById(tripId);
        trip.setWeatherDtoList(weatherDtoList);
        updateTrip(tripId, trip);
        return weatherDtoList;
    }
}
