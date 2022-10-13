package com.example.travelservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {

    private Date startDate;
    private Date endDate;
    private Long locationId;
    private String meal;
    private Long travelerId;

}
