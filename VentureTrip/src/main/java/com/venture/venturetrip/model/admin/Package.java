package com.venture.venturetrip.model.admin;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Package {
    @Id
    private Integer packageID;
    private String packageName;
    private String description;
    private Integer hotelID;
    private Double packageCost;
    private String payment;


}
