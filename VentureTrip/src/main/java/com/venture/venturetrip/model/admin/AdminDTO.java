package com.venture.venturetrip.model.admin;


//import lombok.*;
//
//import javax.persistence.Entity;
//import javax.validation.constraints.NotNull;
//
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
public class AdminDTO {
    private String mobile;
    private String password;
    
    
    public AdminDTO() {
		// TODO Auto-generated constructor stub
	}


	public AdminDTO(String mobile, String password) {
		super();
		this.mobile = mobile;
		this.password = password;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
    
}
