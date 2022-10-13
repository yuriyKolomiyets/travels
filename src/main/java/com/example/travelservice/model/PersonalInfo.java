package com.example.travelservice.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
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

    @OneToOne
    private Traveler traveler;

    public PersonalInfo(String email, String phone, String address, Traveler traveler) {
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.traveler = traveler;
    }
}
