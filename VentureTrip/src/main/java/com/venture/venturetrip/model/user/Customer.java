package com.venture.venturetrip.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private Integer customerID;
    private String customerName;
    private String customerPassword;
    private String address;
    private String mobileNumber;
    private String email;

}
