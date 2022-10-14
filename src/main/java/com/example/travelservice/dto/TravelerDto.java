package com.example.travelservice.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelerDto {

    //person info fields
    private String email;
    private String phone;
    private String address;

    //traveler fields
    private String firstName;
    private String lastName;
    private Integer age;
}
