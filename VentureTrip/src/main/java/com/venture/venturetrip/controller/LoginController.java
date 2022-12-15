package com.venture.venturetrip.controller;

import com.venture.venturetrip.exception.LoginException;
import com.venture.venturetrip.model.admin.AdminDTO;
import com.venture.venturetrip.model.admin.CurrentAdminSession;
import com.venture.venturetrip.services.adminServices.AdminLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AdminLoginServiceImpl adminLogInServiceImpl;

    // for admin login
    @CrossOrigin
    @PostMapping("/adminlogin")
    public ResponseEntity<CurrentAdminSession> logInAdmin(@RequestBody AdminDTO adminDTO) throws LoginException {
        return new ResponseEntity<CurrentAdminSession>(adminLogInServiceImpl.logIntoAccount(adminDTO), HttpStatus.OK);
    }

    // for admin logout
    @CrossOrigin
    @PatchMapping("/adminlogout")
    public ResponseEntity<String> logOutAdmin(@RequestParam(required = false) String key) throws LoginException{
        return new ResponseEntity<String>(adminLogInServiceImpl.logOutAccount(key), HttpStatus.OK);
    }

}
