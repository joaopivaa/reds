package com.reds.models.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.reds.models.model.Usuario;
import com.reds.models.repository.UsuarioRepository;
import com.reds.models.service.JwtService;
import com.reds.models.service.LoginService;
import com.reds.models.service.components.CriptografarSenha;
import com.reds.models.service.dto.Converter.UsuarioConverter;
import com.reds.models.service.dto.request.LoginRequest;
import com.reds.models.service.dto.response.LoginResponse;
import com.reds.models.service.exception.EntityNotFoundException;
import com.reds.models.service.exception.InvalidPasswordException;
import com.reds.models.service.exception.UserLockedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service // Sinaliza par ao spring que é uma classe de responsabilidade dele para gerenciamento
@Transactional // Acesso ao banco
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UsuarioRepository usuarioRepositoty;
	
	@Autowired
	private CriptografarSenha crypty;
	
	@Autowired
	private JwtService jwtService;
	
	@Override
	public LoginResponse login(LoginRequest loginRequest) {
		
		Usuario usuario = usuarioRepositoty
			.findUsuarioByEmail(loginRequest.getEmail())
			.orElseThrow(
				()-> new EntityNotFoundException(
					String.format("Usuario não localizado %s",
					loginRequest.getEmail())
				)
			);
		
		if (usuario.getEmail().equals(loginRequest.getEmail()) && usuario.isAtivo() == false) {
			throw new UserLockedException(
				String.format(
					"Usuario bloqueado no sistema %s",
					loginRequest.getEmail()
				)
			);
		}
		
		// Verifica se a senha que está vindo é válida
		if (usuario.getEmail().equals(loginRequest.getEmail()) && !crypty.verifyPassword(loginRequest.getSenha(), usuario.getSenha())) {
			throw new InvalidPasswordException("Senha inválida");
		}
		
		String access_token = jwtService.generateAccessToken(usuario);

		String refresh_token = jwtService.generateRefreshToken(usuario);
		
		
		  List<String> roles = usuario.getUsuario() .stream() .map(urp ->
		  urp.getRole().getNomeRoles().getNomeRole()) .collect(Collectors.toSet())
		  .stream() .collect(Collectors.toList());
		  
		  List<String> permissions = usuario.getUsuario() .stream() .map(urp ->
		  urp.getPermissions().getNomePermissions().getNomePermissions())
		  .collect(Collectors.toSet()) .stream() .collect(Collectors.toList());
		 
		
		return UsuarioConverter.usuarioToLoginResponse(usuario, access_token, refresh_token, roles, permissions);
	}

	@Override
	public void logout(String email) {
	}
}