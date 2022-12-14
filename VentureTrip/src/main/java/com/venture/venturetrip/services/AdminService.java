package com.venture.venturetrip.services;

import java.util.List;

import com.venture.venturetrip.exception.AdminException;
import com.venture.venturetrip.exception.HotelException;
import com.venture.venturetrip.model.admin.Admin;
import com.venture.venturetrip.model.admin.AdminSignInDTO;
import com.venture.venturetrip.model.admin.Hotel;


public interface AdminService {
    public Admin createAdmin(AdminSignInDTO adminsiginDto) throws AdminException;
    
    public Hotel addNewHotal(Hotel hotal) throws HotelException;
    
    public Hotel updateHotalDetails(Hotel hotal) throws HotelException;
    
    public Hotel RemoveHotalDetails(Integer hotelID) throws HotelException;
    
    public List<Hotel> getAllHotelDetails() throws HotelException;
    
}
