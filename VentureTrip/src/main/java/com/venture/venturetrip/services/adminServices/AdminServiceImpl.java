package com.venture.venturetrip.services.adminServices;

import com.venture.venturetrip.exception.AdminException;
import com.venture.venturetrip.exception.TravelsException;
import com.venture.venturetrip.model.admin.*;
import com.venture.venturetrip.repository.adminRepo.AdminDao;
import com.venture.venturetrip.repository.adminRepo.AdminSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Admin updateAdmin(AdminSignInDTO adminsiginDto, String key) throws AdminException {
        Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
        if(!optCurrAdmin.isPresent()) {
            throw new AdminException("Unauthorised Access! Enter Correct UUID");
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