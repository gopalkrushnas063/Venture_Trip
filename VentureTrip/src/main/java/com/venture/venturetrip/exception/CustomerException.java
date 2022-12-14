package com.venture.venturetrip.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

public class CustomerException extends Exception {

	public CustomerException() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerException(String mesg) {
		super(mesg);
	}
	
}
