package com.venture.venturetrip.model.admin;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer hotelID;

	@Size(min = 1, message = "Hotel name cannot be null")
    private String hotelName;
    private String hotelType;
    private String hotelDescription;
    private String address;
	@NotNull(message = "Price should not be negative value")
	@NotEmpty(message = "Price should not be negative value")
    private String rent;
    


}
