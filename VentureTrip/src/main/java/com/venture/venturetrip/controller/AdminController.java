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


    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer() throws CustomerException {

        List<Customer> c = cService.getallCustomer();

        return new ResponseEntity<List<Customer>>(c, HttpStatus.OK);

    }

    @GetMapping("/travels")
    public ResponseEntity <List<Travels>> getallTravels() throws CustomerException {

        List<Travels> c = cService.getallTravels();

        return new ResponseEntity <List<Travels>> (c, HttpStatus.OK);

    }

    @GetMapping("/travels/{id}")
    public ResponseEntity<Travels> getTravelById(@PathVariable("id") Integer id) throws CustomerException {

        Travels c = cService.getTravelById(id);

        return new ResponseEntity <Travels> (c, HttpStatus.OK);

    }


    @GetMapping("/ticketByBookingID/{bid}")
    public ResponseEntity<Ticket>  getTicketByBookingId(@PathVariable("bid") Integer bid) throws CustomerException{

        Ticket t = cService.getTicketByBookingId(bid);

        return new ResponseEntity<Ticket>  (t, HttpStatus.OK);


    }


    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerbyid(@PathVariable("id") Integer id) throws CustomerException {

        Customer c = cService.getCustomerBiID(id);

        return new ResponseEntity<Customer>(c, HttpStatus.OK);

    }


    @GetMapping("/FeedBack/{Id}")
    ResponseEntity<FeedBack> virewFeedBack(@PathVariable("Id") Integer feedbackID , @RequestBody FeedBack feedback){

        FeedBack fb = cService.viewFeedBack(feedbackID);

        return new ResponseEntity<FeedBack>(fb,HttpStatus.OK);
    }

    @PutMapping("/packageUpdate/{packageID}")
    ResponseEntity<Package> updatePackageHandler(@PathVariable("packageID") Package pack){
        Package updatedPackage = adminService.updatePackageDetails(pack);
        return new ResponseEntity<Package>(updatedPackage,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/package/{packageID}")
    public ResponseEntity<Package> removePackageHandler(@PathVariable("packageID") Integer packID){
        Package aPackage = adminService.removePackageDetailsByID(packID);
        return new ResponseEntity<Package>(aPackage,HttpStatus.OK);
    }
}
