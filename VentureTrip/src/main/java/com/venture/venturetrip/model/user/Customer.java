package com.venture.venturetrip.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerID;
	@NotNull
    private String customerName;

	@Size(min=4,max=12,message = "Password should has minimum 4 to 12 characters")
	private String customerPassword;

	@NotNull
    private String address;

    @Size(min=10, message ="Mobile Number should be of 10 digits!")
	private String mobileNumber;

	@Email
    private String email;

    

}
