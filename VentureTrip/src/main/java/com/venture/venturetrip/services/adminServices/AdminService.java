package com.venture.venturetrip.services.adminServices;

import com.venture.venturetrip.exception.AdminException;
import com.venture.venturetrip.exception.TravelsException;
import com.venture.venturetrip.model.admin.Admin;
import com.venture.venturetrip.model.admin.AdminSignInDTO;
import com.venture.venturetrip.model.admin.Travels;


public interface AdminService {
    public Admin createAdmin(AdminSignInDTO adminsiginDto) throws AdminException;
    public Admin updateAdmin(AdminSignInDTO adminsiginDTO, String key) throws AdminException;

}
