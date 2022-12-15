package com.venture.venturetrip.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    private Integer bookingID;
    private LocalDateTime bookingDate;
    private Integer packageID;
    private Integer travelsID;
    private Integer vehicleID;
    private Integer routeID;

}
