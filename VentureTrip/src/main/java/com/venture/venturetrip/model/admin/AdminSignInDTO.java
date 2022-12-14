package com.venture.venturetrip.model.admin;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
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
}
