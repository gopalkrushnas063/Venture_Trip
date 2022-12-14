package com.venture.venturetrip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venture.venturetrip.exception.CustomerException;
import com.venture.venturetrip.model.customer.Customer;
import com.venture.venturetrip.repository.CustomerDao;



@Service
public class CustomerServiceImpl  implements CustomerService{
	

	
	@Autowired
	private CustomerDao cDao;
	
	
	@Override
	public Customer regCustomer(Customer customer) throws CustomerException {

		Customer exsistingcustomer = cDao.findByEmail(customer.getEmail());

		if (exsistingcustomer != null) {
			throw new CustomerException("Customer with this email already registered !");
		}

		return cDao.save(customer);
	}

	@Override
	public Customer getCustomerBiID(Integer c_id) throws CustomerException {
		
		Optional<Customer> getCustomer = cDao.findById(c_id);

		if (getCustomer.isPresent()) {
			return getCustomer.get();
		} else {
			throw new CustomerException("No customer with this id " + c_id);
		}
	}

	@Override
	public List<Customer> getallCustomer() throws CustomerException {
	
		
		List<Customer> customer = cDao.findAll();
		
		if (customer.size() == 0) {
			
			throw new CustomerException("No customer in database");
		} else {
			return customer;
		}
	}

	

}
