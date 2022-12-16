package com.venture.venturetrip.services.userServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venture.venturetrip.exception.CustomerException;
import com.venture.venturetrip.exception.FeedbackException;
import com.venture.venturetrip.exception.TicketException;
import com.venture.venturetrip.exception.TravelsException;
import com.venture.venturetrip.model.admin.Travels;
import com.venture.venturetrip.model.user.Customer;
import com.venture.venturetrip.model.user.FeedBack;
import com.venture.venturetrip.model.user.Ticket;
import com.venture.venturetrip.repository.CustomerDao;
import com.venture.venturetrip.repository.FeedBackDao;
import com.venture.venturetrip.repository.TicketDao;
import com.venture.venturetrip.repository.TravelsDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private CustomerDao cDao;
	@Autowired
	private TravelsDao tDao;
	
	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	  private FeedBackDao fDao;
	

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


	@Override
	public List<Travels> getallTravels() throws TravelsException {
		
    List<Travels> travels = tDao.findAll();
		
		if (travels.size() == 0) {
			
			throw new TravelsException("No travel Agency list in database");
		} else {
			return travels;
		}
		
	}

	@Override
	public Travels getTravelById(Integer t_id) throws TravelsException {
		
		Optional<Travels> getTravels = tDao.findById(t_id);
		
		if (getTravels .isPresent()) {
			return getTravels.get();
		} else {
			throw new TravelsException("No Travel Agency with this id " + t_id);
		}
		
	}

	@Override
	public Ticket getTicketById(Integer t_id) throws TicketException {
		// TODO Auto-generated method stub
		Optional<Ticket> getTicket = ticketDao.findById(t_id);

		if (getTicket.isPresent()) {
			return getTicket.get();
		} else {
			throw new TicketException("No Ticket with this id " + t_id);
		}
	}

	@Override
	public Ticket getTicketByBookingId(Integer bookingID) throws TicketException {
		// TODO Auto-generated method stub
		
		Ticket getTicket =  ticketDao.getTicketByBkingId(bookingID);

		if (getTicket!=null) {
			return getTicket;
		} else {
			throw new TicketException("No Ticket with this bookingid " + bookingID);
		}
		
	}

	
	@Override
	public FeedBack addFeedback(FeedBack feedback) throws FeedbackException {
		
		 Optional<FeedBack> fb = fDao.findById(feedback.getFeedbackID());
		
		if(fb.isPresent()) {
			throw new FeedbackException("FeedBack Is Already Submitted");
		}
		
		else {
			return fDao.save(feedback);
		}
		 
	}

	@Override
	public FeedBack viewFeedBack(Integer feedbackID) throws FeedbackException {
		
		Optional<FeedBack> opt = fDao.findById(feedbackID);
		
		if(opt.isEmpty()) {
			throw new FeedbackException("FeedBack Doesn't Exsist By This Id :"+ feedbackID);
		}
		else {
			return opt.get();
		}
		
	}

	@Override
	public FeedBack updateFeedBack(FeedBack feedback) throws FeedbackException {
		
	Optional<FeedBack> opt = fDao.findById(feedback.getFeedbackID());
		
		if(opt.isEmpty()) {
			throw new FeedbackException("FeedBack Doesn't Exsist By This Id :"+ feedback.getFeedbackID());
		}
		else {
			 
			return fDao.save(feedback);
		}
		
	}

	@Override
	public FeedBack deleteFeedBack(FeedBack feedback) throws FeedbackException {
		
		Optional<FeedBack> opt = fDao.findById(feedback.getFeedbackID());
		
		if(opt.isPresent()) {
			
			fDao.delete(feedback);
			
			return feedback;
			}
		else {
			throw new FeedbackException("FeedBack Doesn't Exsist By This Id :"+ feedback.getFeedbackID());
		}
		
	}
	
	

	
}
