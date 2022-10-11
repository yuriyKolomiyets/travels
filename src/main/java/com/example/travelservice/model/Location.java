package com.example.travelservice.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 255)
    private String cityName;

    @Size(min = 3, max = 255)
    private String countryName;

    @Size(min = 3, max = 255)
    private String hotelName;

    @Size(min = 3, max = 255)
    private String latitude;

    @Size(min = 3, max = 255)
    private String longitude;

    @OneToOne(cascade = CascadeType.ALL)
    private Trip trip;
}
