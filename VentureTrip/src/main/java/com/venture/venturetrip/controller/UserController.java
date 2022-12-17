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
	


	
	@PutMapping("/updateCustomers")
	public  ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@RequestParam(required = false) String key ) throws CustomerException {
		
		
		Customer updatedCustomer= cService.updateCustomer(customer, key);
				
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
		
	}
	
	

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerbyid(@PathVariable("id") Integer id) throws CustomerException {

		Customer c = cService.getCustomerBiID(id);

		return new ResponseEntity<Customer>(c, HttpStatus.OK);

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
    
    

	@PostMapping("/newFeedBack")
	ResponseEntity<FeedBack> giveFeedBack(@RequestBody FeedBack feedback){
		
		FeedBack fb = cService.addFeedback(feedback);
		
		return new ResponseEntity<FeedBack>(fb,HttpStatus.CREATED);
	}
	
	@GetMapping("/FeedBack/{Id}")
	ResponseEntity<FeedBack> virewFeedBack(@PathVariable("Id") Integer feedbackID ,@RequestBody FeedBack feedback){
		
		FeedBack fb = cService.viewFeedBack(feedbackID);
		
		return new ResponseEntity<FeedBack>(fb,HttpStatus.OK);
	}
	
	@PutMapping("/updateFeedback/{Id}")
	ResponseEntity<FeedBack> updateFeedBack(@PathVariable("Id") Integer feedbackID, @RequestBody FeedBack feedback){
		
		FeedBack fb = cService.updateFeedBack(feedback);
		
		return new ResponseEntity<FeedBack>(fb,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteFeedback/{Id}")
	ResponseEntity<FeedBack> deleteFeedBack(@PathVariable("Id") Integer feedbackID, @RequestBody FeedBack feedback){
		
		FeedBack fb = cService.deleteFeedBack(feedback);
		
		return new ResponseEntity<FeedBack>(fb,HttpStatus.ACCEPTED);
	}
    
    @PostMapping("/newBooking")
	 ResponseEntity<String> bookNewTicketHandler(@RequestBody Booking booking){
    	
    	String ticketID = cService.bookNewTicket(booking);
    	
    	return new ResponseEntity<String>(ticketID,HttpStatus.ACCEPTED);
		
	}


	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> getAllHotelHandler(){

		List<Hotel> returnedHotels = adminService.getAllHotelDetails();

		return new ResponseEntity<List<Hotel>>(returnedHotels, HttpStatus.OK);
	}
	
	
	@GetMapping("/packages")
	public ResponseEntity<List<Package>> getAllpackage(){

		List<Package> returnedHotels = cService.getPacakge();

		return new ResponseEntity<List<Package>>(returnedHotels, HttpStatus.OK);
	}
	
	
	@GetMapping("/packages/{Id}")
	public ResponseEntity<Package> getpackagebyId(@PathVariable("Id") Integer packageID){

		Package pkg = cService.getPacakgebyId(packageID);
		
	

		return new  ResponseEntity<Package> (pkg, HttpStatus.OK);
	}
	
	@DeleteMapping("/cancelbooking/{id}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable("id") Integer id) throws BookingException{
		Booking booking= cService.cancelBooking(id);
		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
	}

}
