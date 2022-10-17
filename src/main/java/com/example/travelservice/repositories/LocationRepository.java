package com.example.travelservice.repositories;

import com.example.travelservice.model.Location;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.Size;
import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Long> {
    List<Location> findByCityNameAndCountryNameAndHotelName(String cityName, String countryName, String hotelName);

}
