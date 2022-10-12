package com.example.travelservice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"travelers"})
@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Date startDate;
    private Date endDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    @ManyToMany
    @JoinTable(name = "traveler_list",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "traveler_id"))
    private List<Traveler> travelers;

    @Enumerated(EnumType.ORDINAL)
    private Meal meal;

}
