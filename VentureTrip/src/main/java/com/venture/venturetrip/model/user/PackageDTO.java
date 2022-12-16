package com.venture.venturetrip.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PackageDTO {
	
	private Integer packageID;
	private String packageName;
	private String HotelName;
	private String TravellersName;
	private String VehicleType;
	private Integer fare;
	private String RouteForm;
	private String RouteTo;
	

}
