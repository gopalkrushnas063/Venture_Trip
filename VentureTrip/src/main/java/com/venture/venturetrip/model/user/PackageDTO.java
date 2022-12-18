package com.venture.venturetrip.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PackageDTO {

	@JsonIgnore
	private Integer packageID;
	@Size(min = 1,message = "Package name cannot be null")
	private String packageName;
	private String HotelName;
	private String TravellersName;
	private String VehicleType;
	@Min(value = 1000,message = "Package cost can't be less than ₹1000/-")
	private Integer fare;
	private String RouteForm;
	private String RouteTo;
	

}
