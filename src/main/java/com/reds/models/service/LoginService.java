package com.reds.models.service;

import com.reds.models.service.dto.request.LoginRequest;
import com.reds.models.service.dto.response.LoginResponse;

public interface LoginService {
	
	public LoginResponse login(LoginRequest loginRequest);
	
	public void logout(String email);
}
