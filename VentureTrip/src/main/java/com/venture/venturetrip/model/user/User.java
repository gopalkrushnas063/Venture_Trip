package com.venture.venturetrip.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    private Integer userId;

    @Size(min = 5,message = "User should be customer either admin")
    private String userType = "User";
    @Size(min=4,max=12,message = "Password should has minimum 4 to 12 characters")
    private String password;

}
