package com.reds.models.service;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

import com.reds.models.model.Usuario;

public interface JwtService {
	
	public String getEmail(String token); // Conversa entre react e java ocorre através do token
	
	public Date verifyDateExpiration(String token);
	
	public String generateAccessToken(Usuario usuario); // Usuario autenticado / validado
	
	public String generateRefreshToken(Usuario usuario);
	
	public boolean verifyToken(String token);
	
	public boolean isTokenValid(String token, UserDetails userDetails); // Usuário logado
}
