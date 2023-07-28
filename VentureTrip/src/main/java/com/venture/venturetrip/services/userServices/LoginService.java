package com.venture.venturetrip.services.userServices;

import com.venture.venturetrip.exception.LoginException;
import com.venture.venturetrip.model.user.LoginDTO;

public interface LoginService {
    public String logIntoAccount(LoginDTO dto) throws LoginException;
    public String logOutFromAccount(String key) throws LoginException;

}
