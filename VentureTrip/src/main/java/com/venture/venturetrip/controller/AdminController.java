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
import org.springframework.web.bind.annotation.RestController;

import com.venture.venturetrip.exception.AdminException;
import com.venture.venturetrip.model.admin.Admin;
import com.venture.venturetrip.model.admin.AdminSignInDTO;
import com.venture.venturetrip.model.admin.Hotel;
import com.venture.venturetrip.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired AdminService adminService;


    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody AdminSignInDTO admin) throws AdminException {
        return new ResponseEntity<Admin>(adminService.createAdmin(admin), HttpStatus.OK);
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
    public ResponseEntity<List<Hotel>> deleteHotelHandler(){
    	
    	List<Hotel> returnedHotels = adminService.getAllHotelDetails();
    	
    	return new ResponseEntity<List<Hotel>>(returnedHotels, HttpStatus.OK);
    }
    
}
