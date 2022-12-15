package com.venture.venturetrip.services.userServices;

import com.venture.venturetrip.exception.FeedbackException;
import com.venture.venturetrip.model.user.FeedBack;

public interface UserService {
	
     public FeedBack addFeedback(FeedBack feedback) throws FeedbackException;
	
	public FeedBack viewFeedBack(Integer feedbackID) throws FeedbackException;
	
	public FeedBack updateFeedBack(FeedBack feedback) throws FeedbackException;
	
	public FeedBack deleteFeedBack(FeedBack feedback) throws FeedbackException;

	
}
