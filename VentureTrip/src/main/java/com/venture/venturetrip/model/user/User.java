package com.venture.venturetrip.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Integer userId;
    private String userType;
    private String password;

}
