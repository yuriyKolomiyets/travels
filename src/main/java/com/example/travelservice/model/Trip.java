package com.example.travelservice.model;

import com.example.travelservice.dto.WeatherDto;
import com.example.travelservice.dtoconverters.WeatherResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"travelers"})
@NoArgsConstructor
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Trip implements Serializable {

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

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @JsonProperty("weather_dto_list")
    private List <WeatherDto> weatherDtoList;

    public Trip(Date startDate, Date endDate, Location location, List<Traveler> travelers, Meal meal) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.travelers = travelers;
        this.meal = meal;
    }

    public Trip(Date startDate, Date endDate, Location location, Meal meal) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.meal = meal;
    }
}
