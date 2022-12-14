package com.venture.venturetrip.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venture.venturetrip.exception.AdminException;
import com.venture.venturetrip.model.admin.Admin;
import com.venture.venturetrip.model.admin.AdminSignInDTO;
import com.venture.venturetrip.repository.AdminDao;
import com.venture.venturetrip.repository.AdminSessionDAO;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;

    @Autowired
    private AdminSessionDAO adminSessionDAO;
    @Override
    public Admin createAdmin(AdminSignInDTO adminsiginDto) throws AdminException {
        Optional<Admin> opt= adminDao.findByMobile(adminsiginDto.getMobile());
        if(opt.isPresent()) {
            throw new AdminException("Admin Already Registered With Mobile Number "+adminsiginDto.getMobile());
        }else {
            Admin admin = new Admin();
            admin.setAdminName(adminsiginDto.getAdminName());
            admin.setPassword(adminsiginDto.getPassword());
            admin.setMobile(adminsiginDto.getMobile());
            admin.setEmail(adminsiginDto.getEmail());
            admin.setUserType("admin");
            return adminDao.save(admin);
        }
    }
}
