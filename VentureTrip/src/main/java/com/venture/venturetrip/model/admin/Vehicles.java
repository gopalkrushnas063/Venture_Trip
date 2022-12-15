package com.venture.venturetrip.model.admin;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicles {
	@Id
    private Integer vehicleNumber;
    private String vehicleType;
    private Integer capacity;
    
 
}
