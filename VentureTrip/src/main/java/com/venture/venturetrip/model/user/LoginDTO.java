package com.venture.venturetrip.model.user;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginDTO {

	@Email
	private String email;

	@Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$",message = "Password should contains alphabet,numeric ,special characters ans it has also minimum 4 to 12 characters")
	private String password;
	//private String role;
	
}
