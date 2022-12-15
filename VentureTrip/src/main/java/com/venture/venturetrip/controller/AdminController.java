package com.venture.venturetrip.controller;

import com.venture.venturetrip.exception.AdminException;
import com.venture.venturetrip.model.admin.Admin;
import com.venture.venturetrip.model.admin.AdminSignInDTO;
import com.venture.venturetrip.services.adminServices.AdminLoginService;
import com.venture.venturetrip.services.adminServices.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired AdminService adminService;
    @Autowired AdminLoginService adminLoginService;


    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody AdminSignInDTO admin) throws AdminException {
        return new ResponseEntity<Admin>(adminService.createAdmin(admin), HttpStatus.OK);
    }

    // to update admin by passing key
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<Admin> updateAdmin(@RequestBody AdminSignInDTO admin, @RequestParam(required = false) String key) throws AdminException {
        adminLoginService.isLoggedInByUUID(key);
        return new ResponseEntity<Admin>(adminService.updateAdmin(admin, key),HttpStatus.OK);
    }

}
