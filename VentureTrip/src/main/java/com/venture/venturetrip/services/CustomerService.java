package com.venture.venturetrip.services;

import java.util.List;

import com.venture.venturetrip.exception.CustomerException;
import com.venture.venturetrip.model.customer.Customer;

public interface CustomerService {
	
	public Customer regCustomer(Customer customer) throws CustomerException;
	public Customer getCustomerBiID(Integer c_id) throws CustomerException;
	public List<Customer> getallCustomer() throws CustomerException;
	

}
