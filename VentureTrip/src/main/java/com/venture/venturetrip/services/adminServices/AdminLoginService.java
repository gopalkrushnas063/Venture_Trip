package com.venture.venturetrip.services.adminServices;

import com.venture.venturetrip.exception.LoginException;
import com.venture.venturetrip.model.admin.AdminDTO;
import com.venture.venturetrip.model.admin.CurrentAdminSession;



public interface AdminLoginService {
    public CurrentAdminSession logIntoAccount(AdminDTO adminDTO) throws LoginException;
    public String logOutAccount(String key) throws LoginException;
    public boolean isLoggedIn(Integer adminId) throws LoginException ;
    public boolean isLoggedInByUUID(String uuid) throws LoginException ;
}
