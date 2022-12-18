package com.venture.venturetrip.model.user;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginDTO {

	@Email
	private String email;

	@Size(min=4,max=12,message = "Password should has minimum 4 to 12 characters")
	private String password;
	
	//private String role;
	
}
