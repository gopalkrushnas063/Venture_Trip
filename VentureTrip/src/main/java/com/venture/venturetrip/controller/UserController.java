package com.venture.venturetrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venture.venturetrip.exception.BookingException;
import com.venture.venturetrip.exception.CustomerException;
import com.venture.venturetrip.model.admin.Hotel;
import com.venture.venturetrip.model.admin.Travels;
import com.venture.venturetrip.model.user.Booking;
import com.venture.venturetrip.model.user.Customer;
import com.venture.venturetrip.model.user.FeedBack;
import com.venture.venturetrip.model.user.Ticket;
import com.venture.venturetrip.services.adminServices.AdminService;
import com.venture.venturetrip.services.userServices.UserService;
import com.venture.venturetrip.model.admin.Package;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/customer")
public class UserController {
	
	@Autowired
	private UserService cService;

	@Autowired AdminService adminService;
	
    static boolean isLogin = false;

	
	@PutMapping("/updateCustomers")
	public  ResponseEntity<Object> updateCustomer(@RequestBody Customer customer,@RequestParam(required = false) String key ) throws CustomerException {
		
		if(isLogin) {
		Customer updatedCustomer= cService.updateCustomer(customer, key);
				
		return new ResponseEntity<>(updatedCustomer,HttpStatus.OK);
		
		}else {
			
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
	}
	
	

	@GetMapping("/customer/{id}")
	public ResponseEntity<Object> getCustomerbyid(@PathVariable("id") Integer id) throws CustomerException {
	if(isLogin) {
		Customer c = cService.getCustomerBiID(id);

		return new ResponseEntity<>(c, HttpStatus.OK);
	}else {
		
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
	}
	

	
	
	@GetMapping("/travels")
	public ResponseEntity <Object> getallTravels() throws CustomerException {
	if(isLogin) {
		List<Travels> c = cService.getallTravels();

		return new ResponseEntity <> (c, HttpStatus.OK);
	}else {
		
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
	}
	
	@GetMapping("/travels/{id}")
	public ResponseEntity<Object> getTravelById(@PathVariable("id") Integer id) throws CustomerException {

		if(isLogin) {
		Travels c = cService.getTravelById(id);

		return new ResponseEntity <> (c, HttpStatus.OK);
	}else {
		
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
	}
	

	 
    @GetMapping("/ticketByBookingID/{bid}")
	 public ResponseEntity<Object>  getTicketByBookingId(@PathVariable("bid") Integer bid) throws CustomerException{
		if(isLogin) {
			
		    Ticket t = cService.getTicketByBookingId(bid);

			return new ResponseEntity<>(t, HttpStatus.OK);
    }else {
		
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
		 
	 }
    
    

	@PostMapping("/newFeedBack")
	ResponseEntity<Object> giveFeedBack(@RequestBody FeedBack feedback){
		if(isLogin) {
			
		FeedBack fb = cService.addFeedback(feedback);
		
		return new ResponseEntity<>(fb,HttpStatus.CREATED);
	}else {
		
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
	}
	
	@GetMapping("/FeedBack/{Id}")
	ResponseEntity<Object> virewFeedBack(@PathVariable("Id") Integer feedbackID ,@RequestBody FeedBack feedback){
		if(isLogin) {
		FeedBack fb = cService.viewFeedBack(feedbackID);
		
		return new ResponseEntity<>(fb,HttpStatus.OK);
	}else {
		
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
	}
	
	@PutMapping("/updateFeedback/{Id}")
	ResponseEntity<Object> updateFeedBack(@PathVariable("Id") Integer feedbackID, @RequestBody FeedBack feedback){
		if(isLogin) {
		FeedBack fb = cService.updateFeedBack(feedback);
		
		return new ResponseEntity<>(fb,HttpStatus.OK);
	}else {
		
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/deleteFeedback/{Id}")
	ResponseEntity<Object> deleteFeedBack(@PathVariable("Id") Integer feedbackID, @RequestBody FeedBack feedback){
		if(isLogin) {
		FeedBack fb = cService.deleteFeedBack(feedback);
		
		return new ResponseEntity<>(fb,HttpStatus.ACCEPTED);
	}else {
		
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
	}
    
    @PostMapping("/newBooking")
	 ResponseEntity<String> bookNewTicketHandler(@RequestBody Booking booking){
		if(isLogin) {
    	String ticketID = cService.bookNewTicket(booking);
    	
    	return new ResponseEntity<String>(ticketID,HttpStatus.ACCEPTED);
    }else {
		
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
		
	}


	@GetMapping("/hotels")
	public ResponseEntity<Object> getAllHotelHandler(){
		if(isLogin) {
		List<Hotel> returnedHotels = adminService.getAllHotelDetails();

		return new ResponseEntity<>(returnedHotels, HttpStatus.OK);
	}else {
		
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/packages")
	public ResponseEntity<Object> getAllpackage(){
		if(isLogin) {
		List<Package> returnedHotels = cService.getPacakge();

		return new ResponseEntity<>(returnedHotels, HttpStatus.OK);
	}else {
		
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/packages/{Id}")
	public ResponseEntity<Object> getpackagebyId(@PathVariable("Id") Integer packageID){
		if(isLogin) {
		Package pkg = cService.getPacakgebyId(packageID);
		
		return new  ResponseEntity<Object> (pkg, HttpStatus.OK);
	}else {
		
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/cancelbooking/{id}")
	public ResponseEntity<Object> cancelBooking(@PathVariable("id") Integer id) throws BookingException{
		if(isLogin) {
		Booking booking= cService.cancelBooking(id);
		return new ResponseEntity<>(booking,HttpStatus.OK);
	}else {
		
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
	}

}
