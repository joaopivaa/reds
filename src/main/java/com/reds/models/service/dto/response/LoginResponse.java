package com.reds.models.service.dto.response;

import java.util.List;

public class LoginResponse {
	
	private Long idUsuario;
	private String nomeUsuario;
	private String email;
	private String access_token;
	private String refresh_token;
	private List<String> Roles;
	private List<String> Permissions;
	
	public LoginResponse() {
		
	}

	public LoginResponse(Long idUsuario, String nomeUsuario, String email, String access_token, String refresh_token,
			List<String> roles, List<String> permissions) {
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.access_token = access_token;
		this.refresh_token = refresh_token;
		Roles = roles;
		Permissions = permissions;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public List<String> getRoles() {
		return Roles;
	}

	public void setRoles(List<String> roles) {
		Roles = roles;
	}

	public List<String> getPermissions() {
		return Permissions;
	}

	public void setPermissions(List<String> permissions) {
		Permissions = permissions;
	}
	
}
