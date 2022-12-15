package com.venture.venturetrip.services.adminServices;

import java.util.List;

import com.venture.venturetrip.exception.AdminException;
import com.venture.venturetrip.exception.HotelException;
import com.venture.venturetrip.exception.TravelsException;
import com.venture.venturetrip.exception.VehiclesException;
import com.venture.venturetrip.model.admin.Admin;
import com.venture.venturetrip.model.admin.AdminSignInDTO;
import com.venture.venturetrip.model.admin.Hotel;
import com.venture.venturetrip.model.admin.Travels;
import com.venture.venturetrip.model.admin.Vehicles;


public interface AdminService {
    public Admin createAdmin(AdminSignInDTO adminsiginDto) throws AdminException;
    
    public Hotel addNewHotal(Hotel hotal) throws HotelException;
    
    public Hotel updateHotalDetails(Hotel hotal) throws HotelException;
    
    public Hotel RemoveHotalDetails(Integer hotelID) throws HotelException;
    
    public List<Hotel> getAllHotelDetails() throws HotelException;
    
    public Travels addNewTravelsDetails(Travels travels) throws TravelsException;
    
    public Vehicles addNewVehiclesDetials(Vehicles vehicles, Integer travelsID) throws TravelsException, VehiclesException;
    
    
    
}
