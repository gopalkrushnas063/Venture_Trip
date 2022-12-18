package com.venture.venturetrip.services.userServices;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venture.venturetrip.exception.BookingException;
import com.venture.venturetrip.exception.CustomerException;
import com.venture.venturetrip.exception.FeedbackException;
import com.venture.venturetrip.exception.HotelException;
import com.venture.venturetrip.exception.PackageException;
import com.venture.venturetrip.exception.RouteException;
import com.venture.venturetrip.exception.TicketException;
import com.venture.venturetrip.exception.TravelsException;
import com.venture.venturetrip.model.admin.Hotel;
import com.venture.venturetrip.model.admin.Package;
import com.venture.venturetrip.model.admin.Route;
import com.venture.venturetrip.model.admin.Travels;
import com.venture.venturetrip.model.user.Booking;
import com.venture.venturetrip.model.user.CurrentUserSession;
import com.venture.venturetrip.model.user.Customer;
import com.venture.venturetrip.model.user.FeedBack;
import com.venture.venturetrip.model.user.Ticket;
import com.venture.venturetrip.repository.BookingDao;
import com.venture.venturetrip.repository.CustomerDao;
import com.venture.venturetrip.repository.FeedBackDao;
import com.venture.venturetrip.repository.HotelDao;
import com.venture.venturetrip.repository.PackageDao;
import com.venture.venturetrip.repository.RouteDao;
import com.venture.venturetrip.repository.SessionDao;
import com.venture.venturetrip.repository.TravelsDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private CustomerDao cDao;
	@Autowired
	private TravelsDao tDao;
	
	@Autowired
	private RouteDao routeDao;
	
	@Autowired
	private HotelDao hDao;
	
	@Autowired
	  private FeedBackDao fDao;
	
	@Autowired
	 private BookingDao bookingDao;
	
	@Autowired
	 private PackageDao packageDao;
	
	@Autowired
	private SessionDao sDao;
	

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
	public Ticket getTicketByBookingId(Integer bookingID) throws TicketException {
		// TODO Auto-generated method stub
		
		Optional<Booking> booking =  bookingDao.findById(bookingID);
         
		if (booking.isPresent()) {
			 Optional<Package> pack = packageDao.findById(booking.get().getPackageID());
			 if(pack.isPresent()) {
				
					 Ticket ticket = new Ticket();
					 
                     ticket.setTicketID(bookingID);
					 ticket.setDateofJourney(booking.get().getDateOfJourney());
					 ticket.setFrom(pack.get().getRoute().getRouteFrom());
					 ticket.setTo(pack.get().getRoute().getRouteTo());
					 ticket.setTicketCost(booking.get().getAmount());
					 ticket.setName(booking.get().getName());
					 ticket.setAddress(booking.get().getAddress());
					 ticket.setStatus("Booked");
					 ticket.setMobileNo(booking.get().getMobileNo());
					return ticket;
			 }else {
				 throw new BookingException("Package does not exist with choosen Package ID : "+booking.get().getPackageID());
			 }
		} else {
			throw new TicketException("Booking does not exist with bookID : " + bookingID);
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

	@Override
	public String bookNewTicket(Booking booking) throws BookingException {
		
		 Optional<Package> pack = packageDao.findById(booking.getPackageID());
		 
		 if(pack.isPresent()) {
			 if(booking.getAmount().equals(pack.get().getPackageCost())) {
				 
				 Integer bookingID = new Random().nextInt(999999);
				 booking.setBookingID(bookingID);
		     return "Your Booking ID is " +bookingDao.save(booking).getBookingID() + " Please find out Your Ticket with the help of BookingID";
			 }else {
				 throw new BookingException("Amount should be equals to the given price :"+pack.get().getPackageCost());
			 }
			
			 
		 }else {
			 throw new BookingException("Package does not exist with choosen Package ID : "+booking.getPackageID());
		 }
		
		
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		
		CurrentUserSession loggedInUser= sDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}
		
		
	
		
		if(customer.getCustomerID() == loggedInUser.getUserId()) {
			//If LoggedInUser id is same as the id of supplied Customer which we want to update
			return cDao.save(customer);
		}
		else
			throw new CustomerException("Invalid Customer Details, please login first");
	}
	
	
	@Override
	public List<Package> getPacakge() throws PackageException {
		
		 List<Package> pkg = packageDao.findAll();
			
			if (pkg.size() == 0) {
				
				throw new PackageException("No Package list in database");
			} 
			else {
				return  pkg;
			}
			
	}

	@Override
	public Package getPacakgebyId(Integer packId) throws PackageException {
		
     Optional<Package> opt = packageDao.findById(packId);
		
		if(opt.isEmpty()) {
			throw new PackageException("Pacakge Doesn't Exsist By This Id :"+ packId);
		}
		else {
			return opt.get();
		}
	}

	@Override
	public Booking cancelBooking(Integer bookingId) throws BookingException {
		
		Optional<Booking> bookingOptional = bookingDao.findById(bookingId);
		if (bookingOptional.isPresent()) {
			Booking booking = bookingOptional.get();
			bookingDao.deleteById(bookingId);

			return booking;
		} else {
			throw new BookingException("Invalid Booking ID");
		}
	}

	   @Override
		public List<Route> getAllRoute() throws RouteException {
			
			List<Route> list = routeDao.findAll();
			
			if(list == null) {
				throw new RouteException("Route Data Doesn't Exist");
			}
			else {
				return list;
			}
			
			
		}

		@Override
		public List<Route> GetRouteFrom(String from) throws RouteException {
			 
			List<Route> listFrom = routeDao.getRouteFrom(from);
			
			for(Route route: listFrom) {
				
				if(route.getRouteFrom().equalsIgnoreCase(from)) {
					
					
					return listFrom;
					
				}
				else {
					
					throw new RouteException("No Route Found From :"+ from);
				}
				
			}
			
			return null;
		}

		@Override
		public List<Hotel> getHotelByName(String name) throws HotelException {
			
			int flag = 0;
			List<Hotel> opt = hDao.getHotelByName(name);
			
		    for(Hotel hotel: opt) {
		    	
		    	if(hotel.getHotelName().equalsIgnoreCase(name)) {
		    		flag = 1;  
		    	}
		    
		    		
		    }
		    	if(flag == 1) {
		    		return opt;
		    	}
				else {
		          
		    		throw new HotelException("Hotel Doesn't Exist With This Name :"+name);
		    		
		    	}
		}

		@Override
		public List<Hotel> getHotelByRent(String rent) throws HotelException {
			
			
			int flag = 0;
			List<Hotel> hotels = hDao.findByCost(rent);
			
			
			for(Hotel hotel:hotels) {
				
				if(hotel.getRent().equalsIgnoreCase(rent)) {
					
					flag = 1;
				}
			
			}
			if(flag==1) {
				return hotels;
			}
				else {
				throw new HotelException("Hotel Not Found In This Budget :"+rent);
			}
			
		}

		@Override
		public List<Package> getPackageByDate(LocalDate doj) throws PackageException {
			 int flag = 0;
		 	 List<Package> packages = packageDao.findAll();
			  List<Package> newPackage = packageDao.findAll();
			 for(Package pack: packages) {
				 LocalDate localDate = pack.getRoute().getDepartureTime().toLocalDate();
				 if (localDate.equals(doj)) {
					 newPackage.add(pack);
				 }
			 }
			if(newPackage.isEmpty()){
				throw new PackageException("Package doesn't exist on this date : "+doj);
			}
			else {
				return newPackage;
			}
		}

		@Override
		public Hotel findByHotelId(Integer hotelId) throws HotelException {
			
			Optional<Hotel> hotel = hDao.findById(hotelId);
			
			if(hotel.isEmpty()) {
				throw new HotelException("Hotel Doesn't Find By This Id :"+ hotelId);
			}
			
			else {
				
				 return hotel.get();
				
			}
				
			
			
		}


	
	

	
}
