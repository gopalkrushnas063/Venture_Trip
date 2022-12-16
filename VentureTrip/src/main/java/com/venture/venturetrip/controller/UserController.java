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
import org.springframework.web.bind.annotation.RestController;

import com.venture.venturetrip.exception.CustomerException;
import com.venture.venturetrip.model.admin.Travels;
import com.venture.venturetrip.model.user.Customer;
import com.venture.venturetrip.model.user.FeedBack;
import com.venture.venturetrip.model.user.Ticket;
import com.venture.venturetrip.services.userServices.UserService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/customer")
public class UserController {
	
	@Autowired
	private UserService cService;
	
	
	

	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws CustomerException {

		Customer c = cService.regCustomer(customer);

		return new ResponseEntity<Customer>(c, HttpStatus.OK);

	}
	

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerbyid(@PathVariable("id") Integer id) throws CustomerException {

		Customer c = cService.getCustomerBiID(id);

		return new ResponseEntity<Customer>(c, HttpStatus.OK);

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
	
	 @GetMapping("/ticket/{tid}")
	 public ResponseEntity<Ticket>  getTicketById(@PathVariable("tid") Integer tid) throws CustomerException{
		 
		 Ticket t = cService.getTicketById(tid);

			return new ResponseEntity<Ticket>  (t, HttpStatus.OK);
		 
		 
	 }
	 
    @GetMapping("/ticketwithbid/{bid}")
	 public ResponseEntity<Ticket>  getTicketByBookingId(@PathVariable("bid") Integer bid) throws CustomerException{
		 
		    Ticket t = cService.getTicketByBookingId(bid);

			return new ResponseEntity<Ticket>  (t, HttpStatus.OK);
		 
		 
	 }
    
    

	@PostMapping("/FeedBack")
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
    
    
	

	

}
