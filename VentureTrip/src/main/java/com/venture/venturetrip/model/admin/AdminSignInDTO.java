package com.venture.venturetrip.model.admin;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminSignInDTO {
    @NotNull(message = "Name cannot be null")
	@NotEmpty(message = "Name cannot be empty")
    private String adminName;

    @Email(message="Enter your Email properly")
    private String email;

    @Column(unique = true)
	@Pattern(regexp="(^$|[0-9]{10})",message = "Phone number should be 10 digits")
    private String mobile;

	@Pattern(regexp = "(^(?=.[0-9])(?=.[a-z])(?=.[A-Z]).{8,20}$)" , message = "Password should contains alphabet,numeric ,special characters ans it has also minimum 4 to 12 characters")
	private String password;
    
    

    
    
}
