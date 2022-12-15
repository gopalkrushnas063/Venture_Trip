package com.venture.venturetrip.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venture.venturetrip.model.user.FeedBack;
import com.venture.venturetrip.services.userServices.UserService;

@RestController
@RequestMapping("/User")
public class UserController {


	@Autowired
	private UserService uService;
	
	@PostMapping("/FeedBack")
	ResponseEntity<FeedBack> giveFeedBack(@RequestBody FeedBack feedback){
		
		FeedBack fb = uService.addFeedback(feedback);
		
		return new ResponseEntity<FeedBack>(fb,HttpStatus.CREATED);
	}
	
	@GetMapping("/FeedBack/{Id}")
	ResponseEntity<FeedBack> virewFeedBack(@PathVariable("Id") Integer feedbackID ,@RequestBody FeedBack feedback){
		
		FeedBack fb = uService.viewFeedBack(feedbackID);
		
		return new ResponseEntity<FeedBack>(fb,HttpStatus.OK);
	}
	
	@PutMapping("/updateFeedback/{Id}")
	ResponseEntity<FeedBack> updateFeedBack(@PathVariable("Id") Integer feedbackID, @RequestBody FeedBack feedback){
		
		FeedBack opt = uService.updateFeedBack(feedback);
		
		return new ResponseEntity<FeedBack>(opt,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteFeedback/{Id}")
	ResponseEntity<FeedBack> deleteFeedBack(@PathVariable("Id") Integer feedbackID, @RequestBody FeedBack feedback){
		
		FeedBack fb = uService.deleteFeedBack(feedback);
		
		return new ResponseEntity<FeedBack>(fb,HttpStatus.ACCEPTED);
	}






	
}
