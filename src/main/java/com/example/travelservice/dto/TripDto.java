package com.example.travelservice.dto;

import com.example.travelservice.model.Traveler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {

    private Date startDate;
    private Date endDate;
    private Long locationId;
    private String meal;
    private List<Traveler> travelers;

}
