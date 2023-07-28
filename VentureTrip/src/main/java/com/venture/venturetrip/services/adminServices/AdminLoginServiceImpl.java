package com.venture.venturetrip.services.adminServices;

import com.venture.venturetrip.exception.LoginException;
import com.venture.venturetrip.model.admin.Admin;
import com.venture.venturetrip.model.admin.AdminDTO;
import com.venture.venturetrip.model.admin.CurrentAdminSession;
import com.venture.venturetrip.repository.AdminDao;
import com.venture.venturetrip.repository.AdminSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AdminSessionDAO adminSessionDAO;

    @Override
    public CurrentAdminSession logIntoAccount(AdminDTO adminDTO) throws LoginException {
        Optional<Admin> opt = adminDao.findByMobile(adminDTO.getMobile());
        if (!opt.isPresent()) {
            throw new LoginException("Please enter valid Mobile number!");
        }

        Admin admin1 = opt.get();
        Integer adminId = admin1.getAdminID();
        Optional<CurrentAdminSession> currAdminopt1 = adminSessionDAO.findByAdminId(adminId);

        if (currAdminopt1.isPresent()) {
            throw new LoginException("Admin already logged in with this number.");
        }

        if (admin1.getPassword().equals(adminDTO.getPassword())) {

            String key = RandomString.getRandomNumberString();
            CurrentAdminSession currentAdminSession = new CurrentAdminSession(adminId, key, LocalDateTime.now());
            adminSessionDAO.save(currentAdminSession);
            return currentAdminSession;
        } else {
            throw new LoginException("Please Enter valid password.");
        }
    }

    @Override
    public String logOutAccount(String key) throws LoginException {
        Optional<CurrentAdminSession> currAdminOpt = adminSessionDAO.findByUuid(key);
        if (currAdminOpt.isPresent()) {
            CurrentAdminSession currAdmin1 = currAdminOpt.get();
            adminSessionDAO.delete(currAdmin1);
            return "Admin logged out successfully.";
        } else {
            throw new LoginException("Admin does not exist, Enter correct uuid");
        }
    }

    @Override
    public boolean isLoggedIn(Integer adminId) throws LoginException {
        Optional<CurrentAdminSession> opt = adminSessionDAO.findByAdminId(adminId);
        if (opt.isPresent()) return true;
        else throw new LoginException("LogIn first!!!");
    }

    @Override
    public boolean isLoggedInByUUID(String uuid) throws LoginException {
        Optional<CurrentAdminSession> opt = adminSessionDAO.findByUuid(uuid);
        if (opt.isPresent()) return true;
        else throw new LoginException("LogIn first!!!");
    }
}
