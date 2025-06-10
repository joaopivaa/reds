package com.reds.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reds.models.service.LoginService;
import com.reds.models.service.dto.request.LoginRequest;
import com.reds.web.response.MensagemSistema;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/rest")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
		var loginResponse = loginService.login(loginRequest);
		
		return MensagemSistema.showMensagem(
			HttpStatus.OK, 
			loginResponse, 
			request
		);
	}
}
