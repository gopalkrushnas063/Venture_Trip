package com.venture.venturetrip.model.admin;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer adminID;
    private String adminName;
    private String password;
    private String email;
    private String mobile;
    private String userType="admin";
    
    public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer adminID, String adminName, String password, String email, String mobile, String userType) {
		super();
		this.adminID = adminID;
		this.adminName = adminName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.userType = userType;
	}

	public Integer getAdminID() {
		return adminID;
	}

	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
    
    

}
