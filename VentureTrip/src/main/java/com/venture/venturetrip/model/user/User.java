package com.venture.venturetrip.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    private Integer userId;

    @Size(min = 5,message = "User should be customer either admin")
    private String userType = "User";
    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$",message = "Password should contains alphabet,numeric ,special characters ans it has also minimum 4 to 12 characters")
    private String password;

}
