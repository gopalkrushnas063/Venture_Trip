package com.venture.venturetrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venture.venturetrip.model.customer.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

	public Customer findByEmail(String mobileNo);
	
}
