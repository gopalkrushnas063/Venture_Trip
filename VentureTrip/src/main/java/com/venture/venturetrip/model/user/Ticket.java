package com.venture.venturetrip.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticket {
    @Id
    private Integer ticketID;
    private String status;
    private Integer bookingID;

}
