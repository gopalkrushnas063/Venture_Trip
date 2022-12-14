package com.venture.venturetrip.model.customer;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerID;
    private String customerName;
    private String customerPassword;
    private String address;
    private String mobileNumber;
    private String email;
	public Customer() {
		super();
	}
	public Customer(Integer customerID, String customerName, String customerPassword, String address,
			String mobileNumber, String email) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerPassword="
				+ customerPassword + ", address=" + address + ", mobileNumber=" + mobileNumber + ", email=" + email
				+ "]";
	}
    
    
    

}
