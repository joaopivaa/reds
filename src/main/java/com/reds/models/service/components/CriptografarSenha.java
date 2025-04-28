package com.reds.models.service.components;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class CriptografarSenha {
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public String encryptPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	public boolean verifyPassword(String password, String hashedPassword) {
		return BCrypt.checkpw(password, hashedPassword);
	}
}
