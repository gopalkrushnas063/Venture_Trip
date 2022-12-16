package com.venture.venturetrip.services.userServices;

import java.util.List;

import com.venture.venturetrip.exception.BookingException;
import com.venture.venturetrip.exception.CustomerException;
import com.venture.venturetrip.exception.FeedbackException;
import com.venture.venturetrip.exception.TicketException;
import com.venture.venturetrip.exception.TravelsException;
import com.venture.venturetrip.model.admin.Travels;
import com.venture.venturetrip.model.user.Booking;
import com.venture.venturetrip.model.user.Customer;
import com.venture.venturetrip.model.user.FeedBack;
import com.venture.venturetrip.model.user.Ticket;





public interface UserService {
	
	
	public Customer regCustomer(Customer customer) throws CustomerException;
	public Customer getCustomerBiID(Integer c_id) throws CustomerException;
	public List<Customer> getallCustomer() throws CustomerException;
	public List<Travels> getallTravels() throws TravelsException;
	public Travels getTravelById(Integer t_id) throws TravelsException;
	
	
	public Ticket getTicketByBookingId(Integer bookingID) throws TicketException;
	

	public FeedBack addFeedback(FeedBack feedback) throws FeedbackException;
	
	public FeedBack viewFeedBack(Integer feedbackID) throws FeedbackException;
	
	public FeedBack updateFeedBack(FeedBack feedback) throws FeedbackException;
	
	public FeedBack deleteFeedBack(FeedBack feedback) throws FeedbackException;
	
	public String bookNewTicket(Booking booking) throws BookingException;
	
	public Customer updateCustomer(Customer customer,String key)throws CustomerException;
	
	
	
}
