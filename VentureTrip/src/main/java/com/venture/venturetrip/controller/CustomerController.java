package com.venture.venturetrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venture.venturetrip.exception.CustomerException;
import com.venture.venturetrip.model.customer.Customer;
import com.venture.venturetrip.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	
	

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
	
	
	
	
	
	
	

}
