package com.venture.venturetrip.model.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer routeID;
    private String routeFrom;
    private String routeTo;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private LocalDate doj;
    private String pickupPoint;

    @Min(value = 100,message = "Package cost can't be less than ₹1000/-")
    private Double fare;


    private Integer travelsID;


    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Vehicles vehicles;

}
