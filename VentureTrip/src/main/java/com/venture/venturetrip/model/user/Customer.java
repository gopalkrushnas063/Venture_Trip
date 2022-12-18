package com.venture.venturetrip.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

	@Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$",message = "Password should contains alphabet,numeric ,special characters ans it has also minimum 4 to 12 characters")
	private String customerPassword;

	@NotNull
    private String address;

	@Pattern(regexp="(^$|[0-9]{10})",message = "Phone number should be 10 digits")
	private String mobileNumber;

	@Email
    private String email;

    

}
