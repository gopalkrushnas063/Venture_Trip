package com.venture.venturetrip.services;

import com.venture.venturetrip.exception.AdminException;
import com.venture.venturetrip.model.admin.Admin;
import com.venture.venturetrip.model.admin.AdminSignInDTO;


public interface AdminService {
    public Admin createAdmin(AdminSignInDTO adminsiginDto) throws AdminException;
}
