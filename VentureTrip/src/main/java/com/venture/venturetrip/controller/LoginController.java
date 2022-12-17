package com.venture.venturetrip.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venture.venturetrip.exception.AdminException;
import com.venture.venturetrip.exception.CustomerException;
import com.venture.venturetrip.exception.LoginException;
import com.venture.venturetrip.model.admin.Admin;
import com.venture.venturetrip.model.admin.AdminDTO;
import com.venture.venturetrip.model.admin.AdminSignInDTO;
import com.venture.venturetrip.model.admin.CurrentAdminSession;
import com.venture.venturetrip.model.user.Customer;
import com.venture.venturetrip.model.user.LoginDTO;
import com.venture.venturetrip.services.adminServices.AdminLoginServiceImpl;
import com.venture.venturetrip.services.adminServices.AdminService;
import com.venture.venturetrip.services.userServices.LoginService;
import com.venture.venturetrip.services.userServices.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AdminLoginServiceImpl adminLogInServiceImpl;

    @Autowired
    private UserService cService;
    
    @Autowired
	private LoginService customerLogin;

    @Autowired
    private AdminService adminService;



    @CrossOrigin
    @PostMapping("/registerAdmin")
    public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody AdminSignInDTO admin) throws AdminException {
        return new ResponseEntity<Admin>(adminService.createAdmin(admin), HttpStatus.ACCEPTED);
    }

    // for admin login
    @CrossOrigin
    @PostMapping("/adminlogin")
    public ResponseEntity<CurrentAdminSession> logInAdmin(@RequestBody AdminDTO adminDTO) throws LoginException {
    	CurrentAdminSession cas = adminLogInServiceImpl.logIntoAccount(adminDTO);
    	if(cas != null) {
    		AdminController.isLogin = true;
    	}
        return new ResponseEntity<CurrentAdminSession>(cas, HttpStatus.OK);
    }

    // for admin logout
    @CrossOrigin
    @PatchMapping("/adminlogout")
    public ResponseEntity<String> logOutAdmin(@RequestParam(required = false) String key) throws LoginException{
    	String cas = adminLogInServiceImpl.logOutAccount(key);
    	if(cas != null) {
    		AdminController.isLogin = false;
    	}
        return new ResponseEntity<String>(cas, HttpStatus.OK);
    }


    @PostMapping("/registerCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws CustomerException {

        Customer c = cService.regCustomer(customer);

        return new ResponseEntity<Customer>(c, HttpStatus.OK);

    }
    
	@PostMapping("/customerlogin")
	public ResponseEntity<String> logInCustomer(@RequestBody LoginDTO dto) throws LoginException {
		
		String result = customerLogin.logIntoAccount(dto);
		if(result != null) {
    		UserController.isLogin = true;
    	}

		return new ResponseEntity<String>(result,HttpStatus.OK );
		
		
	}
	
	@PatchMapping("/customerlogout")
	public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		String result = customerLogin.logOutFromAccount(key);
		if(result != null) {
    		UserController.isLogin = false;
    	}
		return result;
		
	}
	

}
