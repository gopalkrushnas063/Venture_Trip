package com.venture.venturetrip.services.adminServices;

import java.util.List;

import com.venture.venturetrip.exception.AdminException;
import com.venture.venturetrip.exception.HotelException;
import com.venture.venturetrip.exception.PackageException;
import com.venture.venturetrip.exception.RouteException;
import com.venture.venturetrip.exception.TravelsException;
import com.venture.venturetrip.exception.VehiclesException;
import com.venture.venturetrip.model.admin.Admin;
import com.venture.venturetrip.model.admin.AdminSignInDTO;
import com.venture.venturetrip.model.admin.Hotel;
import com.venture.venturetrip.model.admin.Package;
import com.venture.venturetrip.model.admin.Travels;
import com.venture.venturetrip.model.admin.Vehicles;
import com.venture.venturetrip.model.user.PackageDTO;


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
    

    public Package addNewPackageDetails(Package package1, Integer travelsID, Integer routeID, Integer hotelID) throws PackageException;
    
    public List<PackageDTO> getAllPackageDetails(String from, String to) throws PackageException;
    public Package updatePackageDetails(Package pack) throws PackageException;

    public Package removePackageDetailsByID(Integer packID) throws PackageException;
    
}
