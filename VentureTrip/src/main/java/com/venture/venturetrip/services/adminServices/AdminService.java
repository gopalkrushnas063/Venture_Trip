package com.venture.venturetrip.services.adminServices;

import java.util.List;

import com.venture.venturetrip.exception.*;
import com.venture.venturetrip.model.admin.Admin;
import com.venture.venturetrip.model.admin.AdminSignInDTO;
import com.venture.venturetrip.model.admin.Hotel;
import com.venture.venturetrip.model.admin.Travels;
import com.venture.venturetrip.model.admin.Vehicles;


public interface AdminService {
    public Admin createAdmin(AdminSignInDTO adminsiginDto) throws AdminException;
    public Admin updateAdmin(AdminSignInDTO adminsiginDTO, String key) throws AdminException;
    
    public Hotel addNewHotal(Hotel hotal) throws HotelException;
    
    public Hotel updateHotalDetails(Hotel hotal) throws HotelException;
    
    public Hotel RemoveHotalDetails(Integer hotelID) throws HotelException;
    
    public List<Hotel> getAllHotelDetails() throws HotelException;
    
    public Travels addNewTravelsDetails(Travels travels) throws TravelsException;
    public Travels updateTravelDetails(Travels travels) throws TravelsException;
    public Travels removeTravel(Integer travelersID) throws TravelsException;
    
    public Vehicles addNewVehiclesDetails(Vehicles vehicles) throws TravelsException, VehiclesException;
    public Vehicles updateVehicleDetails(Vehicles vehicles) throws VehiclesException, RouteException;


    
}
