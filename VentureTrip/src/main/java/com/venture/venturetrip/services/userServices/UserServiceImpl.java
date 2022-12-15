package com.venture.venturetrip.services.userServices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venture.venturetrip.exception.FeedbackException;
import com.venture.venturetrip.model.user.FeedBack;
import com.venture.venturetrip.repository.FeedBackDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private FeedBackDao fDao;

	@Override
	public FeedBack addFeedback(FeedBack feedback) throws FeedbackException {
		
		
		 FeedBack fb = fDao.save(feedback);
			
			return fb;
			
			
				
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
			 
			FeedBack updated = fDao.save(feedback); 
			
			return updated;
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
