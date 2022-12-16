package com.venture.venturetrip.services.adminServices;

import java.util.List;
import java.util.Optional;

import com.venture.venturetrip.exception.*;
import com.venture.venturetrip.model.admin.*;
import com.venture.venturetrip.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;

    @Autowired
    private AdminSessionDAO adminSessionDAO;
    
    @Autowired
    private HotelDao hotelDao;
    
    @Autowired
    private TravelsDao travelsdao;
    
    @Autowired
    private VehiclesDao vehiclesDao;
	@Autowired
	private RouteDao routeDao;


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
	public Admin updateAdmin(AdminSignInDTO adminsiginDto, String key) throws AdminException {
		Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		if(!optCurrAdmin.isPresent()) {
			throw new AdminException("Unauthorised Access! Enter Correct UUID");
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


	@Override
	public Travels addNewTravelsDetails(Travels travels) throws TravelsException {
		
		  return travelsdao.save(travels);
		  
	
	}

	@Override
	public Travels updateTravelDetails(Travels travels) throws TravelsException {

		Optional<Travels> opt = travelsdao.findById(travels.getTravelsID());
		if(opt.isPresent()){
			Travels existingTraveler = opt.get();
			travels.setRoutes(existingTraveler.getRoutes());
			return travelsdao.save(travels);
		}else{
			throw new TravelsException("Travelers does not exist with travelers ID : "+travels.getTravelsID());
		}


	}

	@Override
	public Travels removeTravel(Integer travelersID) throws TravelsException {
		Optional<Travels> opt = travelsdao.findById(travelersID);
		if(opt.isPresent()){
			travelsdao.deleteById(travelersID);
			return opt.get();
		}else {
			throw new TravelsException("Travellers does not exist with Traveler's ID : "+travelersID);
		}

	}


	@Override
	public Vehicles addNewVehiclesDetails(Vehicles vehicles) throws RouteException {
		Optional<Route> opt = routeDao.findById(vehicles.getRouteID());
		if(opt.isPresent()){
			return vehiclesDao.save(vehicles);
		}else{
			throw new RouteException("Route not found with route ID : "+vehicles.getRouteID());
		}

		
	}

	@Override
	public Vehicles updateVehicleDetails(Vehicles vehicles) throws VehiclesException,RouteException {
		Optional<Vehicles> opt = vehiclesDao.findById(vehicles.getVehicleNumber());
		if(opt.isPresent()){
			Optional<Route> route = routeDao.findById(vehicles.getRouteID());
			if(route.isPresent()){
//				route.get().setVehicles(vehicles);
				return vehiclesDao.save(vehicles);
			}else {
				throw new RouteException("Route does not exist with the given route ID : "+vehicles.getRouteID());
			}
		}else {
			throw new VehiclesException("Vehicle does not exist with the vehicle number : "+vehicles.getVehicleNumber());
		}

	}



}
