package com.venture.venturetrip.model.admin;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer adminID;
    @Size(min=3,max=20, message = "Admin Name should have minimum 3 and maximum 20 character!")
    private String adminName;

    @NotNull
    @Size(min = 2, max = 30,message = "Password should contains alphabet,numeric ,special characters ans it has also minimum 4 to 12 characters")
    private String password;
    @Email
    private String email;
    @Size(min=10, message = "Mobile Number should have minimum 10 character!" )
    private String mobile;
    
    private String userType="admin";
    

    

}
