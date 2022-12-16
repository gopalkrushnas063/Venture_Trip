package com.venture.venturetrip.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venture.venturetrip.exception.AdminException;
import com.venture.venturetrip.model.admin.Admin;
import com.venture.venturetrip.model.admin.AdminSignInDTO;
import com.venture.venturetrip.model.admin.Hotel;
import com.venture.venturetrip.model.admin.Package;
import com.venture.venturetrip.model.admin.Route;
import com.venture.venturetrip.model.admin.Travels;
import com.venture.venturetrip.model.admin.Vehicles;
import com.venture.venturetrip.model.user.PackageDTO;
import com.venture.venturetrip.services.adminServices.AdminLoginService;
import com.venture.venturetrip.services.adminServices.AdminService;
import com.venture.venturetrip.services.adminServices.RouteServices;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired AdminService adminService;
    @Autowired AdminLoginService adminLoginService;
    @Autowired RouteServices routeServices;





    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody AdminSignInDTO admin) throws AdminException {
        return new ResponseEntity<Admin>(adminService.createAdmin(admin), HttpStatus.ACCEPTED);
    }
    // to update admin by passing key
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<Admin> updateAdmin(@RequestBody AdminSignInDTO admin, @RequestParam(required = false) String key) throws AdminException {
        adminLoginService.isLoggedInByUUID(key);
        return new ResponseEntity<Admin>(adminService.updateAdmin(admin, key),HttpStatus.ACCEPTED);
    }
    
    @PostMapping("/hotels")
    public ResponseEntity<Hotel> addNewHotelHandler(@RequestBody Hotel hotel){
    	
    	Hotel returnedHotel = adminService.addNewHotal(hotel);
    	
    	return new ResponseEntity<Hotel>(returnedHotel, HttpStatus.ACCEPTED);
    }
    
    
    @PutMapping("/hotels")
    public ResponseEntity<Hotel> updateHotelHandlerDetails(@RequestBody Hotel hotel){
    	
    	Hotel returnedHotel = adminService.updateHotalDetails(hotel);
    	
    	return new ResponseEntity<Hotel>(returnedHotel, HttpStatus.ACCEPTED);
    }
    
    
    @DeleteMapping("/hotels/{hotelID}")
    public ResponseEntity<Hotel> deleteHotelHandler(@PathVariable("hotelID") Integer hotelID){
    	
    	Hotel returnedHotel = adminService.RemoveHotalDetails(hotelID);
    	
    	return new ResponseEntity<Hotel>(returnedHotel, HttpStatus.OK);
    }
    
    
    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getAllHotelHandler(){
    	
    	List<Hotel> returnedHotels = adminService.getAllHotelDetails();
    	
    	return new ResponseEntity<List<Hotel>>(returnedHotels, HttpStatus.OK);
    }
    
    @PostMapping("/travels")
    public ResponseEntity<Travels> addNewTravelsHandler(@RequestBody Travels travels){
    	
    	Travels returnedTravels = adminService.addNewTravelsDetails(travels);
    	
    	return new ResponseEntity<Travels>(returnedTravels, HttpStatus.ACCEPTED);
    }
    
    @PostMapping("/vehicles")
    public ResponseEntity<Vehicles> addNewVehicleHandler(@RequestBody Vehicles vehicle){
    	
    	Vehicles returnedTravels = adminService.addNewVehiclesDetails(vehicle);
    	
    	return new ResponseEntity<Vehicles>(returnedTravels, HttpStatus.ACCEPTED);
    }



    @CrossOrigin
    @PostMapping("/routes")
    public ResponseEntity<Route> addRoute(@RequestBody Route route){

        Route route2 = routeServices.addRoute(route);
        return new ResponseEntity<Route>(route2,HttpStatus.ACCEPTED);
    }

    @PutMapping("/routes")
    public ResponseEntity<Route> updateRoute(@RequestBody Route route){
        Route updatedRoute = routeServices.updateRoute(route);
        return new ResponseEntity<Route>(updatedRoute,HttpStatus.ACCEPTED);
    }

    @PutMapping("/travels")
    public ResponseEntity<Travels> updateTravellers(@RequestBody Travels travels){
        Travels updatedTravel =  adminService.updateTravelDetails(travels);

        return new ResponseEntity<Travels>(updatedTravel,HttpStatus.ACCEPTED);
    }

    @PutMapping("/vehicle")
    public ResponseEntity<Vehicles> updateVehicles(@RequestBody Vehicles vehicles){
        Vehicles updatedVehicles =  adminService.updateVehicleDetails(vehicles);

        return new ResponseEntity<Vehicles>(updatedVehicles,HttpStatus.ACCEPTED);
    }



    @DeleteMapping("/travels/{travellerID}")
    public ResponseEntity<Travels> removeTravellerHandler(@PathVariable("travellerID") Integer travelerID){
        Travels travels = adminService.removeTravel(travelerID);
        return new ResponseEntity<Travels>(travels,HttpStatus.OK);
    }


    @DeleteMapping("/route/{routeID}")
    public ResponseEntity<Route> removeRouteHandler(@PathVariable("routeID") Integer routeID){
        Route route = routeServices.deleteRoute(routeID);
        return new ResponseEntity<Route>(route,HttpStatus.OK);
    }
    
    @PostMapping("/package")
    public ResponseEntity<Package> addNewPackageHandler(@RequestBody Package package1, @RequestParam("travelsID") Integer travelsID,@RequestParam("routeID") Integer routeID, @RequestParam("hotelID") Integer hotelID){
    	
    	Package returnedPackage = adminService.addNewPackageDetails(package1,travelsID,routeID,hotelID);
    	
    	return new ResponseEntity<Package>(returnedPackage,HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/packages")
    public ResponseEntity<List<PackageDTO>> getAllPackageHandler(@RequestParam("from") String from, @RequestParam("to") String to){
    	
    	List<PackageDTO> packagesDTOs = adminService.getAllPackageDetails(from, to);
    	
    	return new ResponseEntity<>(packagesDTOs,HttpStatus.OK);
    }
}
