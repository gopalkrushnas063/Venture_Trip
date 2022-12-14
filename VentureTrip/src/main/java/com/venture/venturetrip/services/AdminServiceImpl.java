package com.venture.venturetrip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venture.venturetrip.exception.AdminException;
import com.venture.venturetrip.exception.HotelException;
import com.venture.venturetrip.model.admin.Admin;
import com.venture.venturetrip.model.admin.AdminSignInDTO;
import com.venture.venturetrip.model.admin.Hotel;
import com.venture.venturetrip.repository.AdminDao;
import com.venture.venturetrip.repository.AdminSessionDAO;
import com.venture.venturetrip.repository.HotelDao;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;

    @Autowired
    private AdminSessionDAO adminSessionDAO;
    
    @Autowired
    private HotelDao hotelDao;
    
    @Override
    public Admin createAdmin(AdminSignInDTO adminsiginDto) throws AdminException {
        Optional<Admin> opt= adminDao.findByMobile(adminsiginDto.getMobile());
        if(opt.isPresent()) {
            throw new AdminException("Admin Already Registered With Mobile Number "+adminsiginDto.getMobile());
        }else {
            Admin admin = new Admin();
            admin.setAdminName(adminsiginDto.getAdminName());
            admin.setPassword(adminsiginDto.getPassword());
            admin.setMobile(adminsiginDto.getMobile());
            admin.setEmail(adminsiginDto.getEmail());
            admin.setUserType("admin");
            return adminDao.save(admin);
        }
    }
    
    
	@Override
	public Hotel addNewHotal(Hotel hotel) throws HotelException {
	
	   return hotelDao.save(hotel);
	}


	@Override
	public Hotel updateHotalDetails(Hotel hotel) throws HotelException {
		
		Optional<Hotel> opt = hotelDao.findById(hotel.getHotelID());
		
		if(opt.isPresent()) {
		
		hotelDao.save(hotel);
		return hotel;
		}else {
			throw new HotelException("Hotel not found with HotelID : "+hotel.getHotelID());
		}
		
		
	}


	@Override
	public Hotel RemoveHotalDetails(Integer hotelID) throws HotelException {
		
        Optional<Hotel> opt = hotelDao.findById(hotelID);
		
		if(opt.isPresent()) {
		
		hotelDao.deleteById(hotelID);
		return opt.get();
		}else {
			throw new HotelException("Hotel not found with HotelID : "+hotelID);
		}
	}


	@Override
	public List<Hotel> getAllHotelDetails() throws HotelException {
		
		List<Hotel> hotels = hotelDao.findAll();
		
		if(hotels.isEmpty()) {
			throw new HotelException("No any Hotel found in Database..");
		}else {
			return hotels;
		}
	}
	
	
	
	
	
	
}
