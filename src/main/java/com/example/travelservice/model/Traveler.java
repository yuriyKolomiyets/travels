package com.example.travelservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Traveler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 255)
    private String firstName;

    @Size(min = 3, max = 255)
    private String lastName;

    @Min(1)
    @Max(100)
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    private PersonalInfo personalInfo;

    @ManyToMany(mappedBy = "travelers")
    private List<Trip> tripsList;

    public Traveler(String firstName, String lastName, Integer age, PersonalInfo personalInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.personalInfo = personalInfo;
    }
}
