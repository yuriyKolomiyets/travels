package com.example.travelservice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 7, max = 255)
    private String email;

    @Size(min = 7, max = 15)
    private String phone;

    @Size(min = 3, max = 255)
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    private Traveler traveler;
}
