package com.example.travelservice.repositories;

import com.example.travelservice.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
