package com.venture.venturetrip.model.admin;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@Data
public class AdminSignInDTO {
    @NotNull(message = "Name cannot be null")
    private String adminName;

    @Email(message="Enter your Email properly")
    @NotNull(message = "Email is mandatory")
    private String email;

    @Column(unique = true)
    @Size(max = 10,min = 10)
    @NotNull(message = "Mobile is mandatory")
    private String mobile;

    @NotNull(message = "Password is mandatory")
    private String password;
    
    
    public AdminSignInDTO() {
		// TODO Auto-generated constructor stub
	}


	public AdminSignInDTO(@NotNull(message = "Name cannot be null") String adminName,
			@Email(message = "Enter your Email properly") @NotNull(message = "Email is mandatory") String email,
			@Size(max = 10, min = 10) @NotNull(message = "Mobile is mandatory") String mobile,
			@NotNull(message = "Password is mandatory") String password) {
		super();
		this.adminName = adminName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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
