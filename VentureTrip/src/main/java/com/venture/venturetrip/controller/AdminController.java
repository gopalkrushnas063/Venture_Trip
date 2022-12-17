package com.venture.venturetrip.controller;

import java.util.List;

import javax.validation.Valid;

import com.venture.venturetrip.exception.CustomerException;
import com.venture.venturetrip.model.user.Customer;
import com.venture.venturetrip.model.user.FeedBack;
import com.venture.venturetrip.model.user.Ticket;
import com.venture.venturetrip.repository.CustomerDao;
import com.venture.venturetrip.repository.PackageDao;
import com.venture.venturetrip.services.userServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Autowired UserService cService;
    @Autowired
    private PackageDao packageDao;
    
    static boolean isLogin = false;


    // to update admin by passing key
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<Object> updateAdmin(@RequestBody AdminSignInDTO admin, @RequestParam(required = false) String key) throws AdminException {
    	 if(isLogin) {
    	adminLoginService.isLoggedInByUUID(key);
        return new ResponseEntity<>(adminService.updateAdmin(admin, key),HttpStatus.ACCEPTED);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }
    
    @PostMapping("/hotels")
    public ResponseEntity<Object> addNewHotelHandler(@RequestBody Hotel hotel){
    	 if(isLogin) {
    	Hotel returnedHotel = adminService.addNewHotal(hotel);
    	
    	return new ResponseEntity<>(returnedHotel, HttpStatus.ACCEPTED);
    	 }else {
    		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
    	 }
    }
    
    
    @PutMapping("/hotels")
    public ResponseEntity<Object> updateHotelHandlerDetails(@RequestBody Hotel hotel){
   	 if(isLogin) {
    	Hotel returnedHotel = adminService.updateHotalDetails(hotel);
    	
    	return new ResponseEntity<>(returnedHotel, HttpStatus.ACCEPTED);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }
    
    
    @DeleteMapping("/hotels/{hotelID}")
    public ResponseEntity<Object> deleteHotelHandler(@PathVariable("hotelID") Integer hotelID){
   	 if(isLogin) {
    	Hotel returnedHotel = adminService.RemoveHotalDetails(hotelID);
    	
    	return new ResponseEntity<>(returnedHotel, HttpStatus.OK);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }
    
    
    @GetMapping("/hotels")
    public ResponseEntity<Object> getAllHotelHandler(){
   	 if(isLogin) {
    	List<Hotel> returnedHotels = adminService.getAllHotelDetails();
    	
    	return new ResponseEntity<>(returnedHotels, HttpStatus.OK);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }
    
    @PostMapping("/travels")
    public ResponseEntity<Object> addNewTravelsHandler(@RequestBody Travels travels){
   	 if(isLogin) {
    	Travels returnedTravels = adminService.addNewTravelsDetails(travels);
    	
    	return new ResponseEntity<>(returnedTravels, HttpStatus.ACCEPTED);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }
    
    @PostMapping("/vehicles")
    public ResponseEntity<Object> addNewVehicleHandler(@RequestBody Vehicles vehicle){
   	 if(isLogin) {
    	Vehicles returnedTravels = adminService.addNewVehiclesDetails(vehicle);
    	
    	return new ResponseEntity<>(returnedTravels, HttpStatus.ACCEPTED);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }



    @CrossOrigin
    @PostMapping("/routes")
    public ResponseEntity<Object> addRoute(@RequestBody Route route){
   	 if(isLogin) {
        Route route2 = routeServices.addRoute(route);
        return new ResponseEntity<>(route2,HttpStatus.ACCEPTED);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }

    @PutMapping("/routes")
    public ResponseEntity<Object> updateRoute(@RequestBody Route route){
   	 if(isLogin) {
        Route updatedRoute = routeServices.updateRoute(route);
        return new ResponseEntity<>(updatedRoute,HttpStatus.ACCEPTED);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }

    @PutMapping("/travels")
    public ResponseEntity<Object> updateTravellers(@RequestBody Travels travels){
   	 if(isLogin) {
        Travels updatedTravel =  adminService.updateTravelDetails(travels);

        return new ResponseEntity<>(updatedTravel,HttpStatus.ACCEPTED);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }

    @PutMapping("/vehicle")
    public ResponseEntity<Object> updateVehicles(@RequestBody Vehicles vehicles){
   	 if(isLogin) {
        Vehicles updatedVehicles =  adminService.updateVehicleDetails(vehicles);

        return new ResponseEntity<>(updatedVehicles,HttpStatus.ACCEPTED);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }



    @DeleteMapping("/travels/{travellerID}")
    public ResponseEntity<Object> removeTravellerHandler(@PathVariable("travellerID") Integer travelerID){
   	 if(isLogin) {
        Travels travels = adminService.removeTravel(travelerID);
        return new ResponseEntity<>(travels,HttpStatus.OK);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }


    @DeleteMapping("/route/{routeID}")
    public ResponseEntity<Object> removeRouteHandler(@PathVariable("routeID") Integer routeID){
   	 if(isLogin) {
        Route route = routeServices.deleteRoute(routeID);
        return new ResponseEntity<>(route,HttpStatus.OK);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }
    
    @PostMapping("/package")
    public ResponseEntity<Object> addNewPackageHandler(@RequestBody Package package1, @RequestParam("travelsID") Integer travelsID,@RequestParam("routeID") Integer routeID, @RequestParam("hotelID") Integer hotelID){
   	 if(isLogin) {
    	Package returnedPackage = adminService.addNewPackageDetails(package1,travelsID,routeID,hotelID);
    	
    	return new ResponseEntity<>(returnedPackage,HttpStatus.ACCEPTED);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }
    
    @GetMapping("/packages")
    public ResponseEntity<Object> getAllPackageHandler(@RequestParam("from") String from, @RequestParam("to") String to){
   	 if(isLogin) {
    	List<PackageDTO> packagesDTOs = adminService.getAllPackageDetails(from, to);
    	
    	return new ResponseEntity<>(packagesDTOs,HttpStatus.OK);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }


    @GetMapping("/customers")
    public ResponseEntity<Object> getAllCustomer() throws CustomerException {
   	 if(isLogin) {
        List<Customer> c = cService.getallCustomer();

        return new ResponseEntity<>(c, HttpStatus.OK);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }

    }

    @GetMapping("/travels")
    public ResponseEntity <Object> getallTravels() throws CustomerException {
   	 if(isLogin) {
        List<Travels> c = cService.getallTravels();

        return new ResponseEntity <> (c, HttpStatus.OK);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }

    }

    @GetMapping("/travels/{id}")
    public ResponseEntity<Object> getTravelById(@PathVariable("id") Integer id) throws CustomerException {
   	 if(isLogin) {
        Travels c = cService.getTravelById(id);

        return new ResponseEntity <> (c, HttpStatus.OK);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }

    }


    @GetMapping("/ticketByBookingID/{bid}")
    public ResponseEntity<Object>  getTicketByBookingId(@PathVariable("bid") Integer bid) throws CustomerException{
   	 if(isLogin) {
        Ticket t = cService.getTicketByBookingId(bid);

        return new ResponseEntity<>  (t, HttpStatus.OK);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }


    }


    @GetMapping("/customer/{id}")
    public ResponseEntity<Object> getCustomerbyid(@PathVariable("id") Integer id) throws CustomerException {
   	 if(isLogin) {
        Customer c = cService.getCustomerBiID(id);

        return new ResponseEntity<>(c, HttpStatus.OK);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }

    }


    @GetMapping("/FeedBack/{Id}")
    ResponseEntity<Object> virewFeedBack(@PathVariable("Id") Integer feedbackID , @RequestBody FeedBack feedback){
   	 if(isLogin) {
        FeedBack fb = cService.viewFeedBack(feedbackID);

        return new ResponseEntity<>(fb,HttpStatus.OK);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }

    @PutMapping("/packageUpdate/{packageID}")
    ResponseEntity<Object> updatePackageHandler(@PathVariable("packageID") Package pack){
   	 if(isLogin) {
        Package updatedPackage = adminService.updatePackageDetails(pack);
        return new ResponseEntity<>(updatedPackage,HttpStatus.ACCEPTED);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }

    @DeleteMapping("/package/{packageID}")
    public ResponseEntity<Object> removePackageHandler(@PathVariable("packageID") Integer packID){
   	 if(isLogin) {
        Package aPackage = adminService.removePackageDetailsByID(packID);
        return new ResponseEntity<>(aPackage,HttpStatus.OK);
    }else {
		 return new ResponseEntity<>("Please, Login first!", HttpStatus.ACCEPTED);	 
	 }
    }
}
