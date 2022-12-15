package com.venture.venturetrip.model.admin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer hotelID;
    private String hotelName;
    private String hotelType;
    private String hotelDescription;
    private String address;
    private String rent;
    
    public Hotel() {
		// TODO Auto-generated constructor stub
	}

	public Hotel(Integer hotelID, String hotelName, String hotelType, String hotelDescription, String address,
			String rent) {
		super();
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.hotelType = hotelType;
		this.hotelDescription = hotelDescription;
		this.address = address;
		this.rent = rent;
	}

	public Integer getHotelID() {
		return hotelID;
	}

	public void setHotelID(Integer hotelID) {
		this.hotelID = hotelID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelType() {
		return hotelType;
	}

	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}

	public String getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}
    
    
    

}
