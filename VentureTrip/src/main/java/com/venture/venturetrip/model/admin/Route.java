package com.venture.venturetrip.model.admin;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Route {
    @Id
    private String routeID;
    private String routeFrom;
    private String routeTo;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private LocalDateTime doj;
    private String pickupPoint;
    private Double fare;

}
