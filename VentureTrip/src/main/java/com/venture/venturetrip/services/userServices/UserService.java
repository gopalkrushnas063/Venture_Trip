package com.venture.venturetrip.services.userServices;

import java.util.List;



import com.venture.venturetrip.exception.CustomerException;
import com.venture.venturetrip.exception.TicketException;
import com.venture.venturetrip.exception.TravelsException;
import com.venture.venturetrip.model.admin.Travels;
import com.venture.venturetrip.model.user.Customer;
import com.venture.venturetrip.model.user.Ticket;





public interface UserService {
	
	
	public Customer regCustomer(Customer customer) throws CustomerException;
	public Customer getCustomerBiID(Integer c_id) throws CustomerException;
	public List<Customer> getallCustomer() throws CustomerException;
	public List<Travels> getallTravels() throws TravelsException;
	public Travels getTravelById(Integer t_id) throws TravelsException;
	
	
    public Ticket getTicketById(Integer t_id) throws TicketException;
	
	
	public Ticket getTicketByBookingId(Integer bookingID) throws TicketException;
	
	
	
	
}
