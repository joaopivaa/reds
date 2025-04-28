package com.reds.models.service.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.reds.models.model.Usuario;

public class UsuarioSistema implements UserDetails{

	private static final long serialVersionUID = -1895289219810046354L;

	private Usuario usuario;
	private Long id;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	
	public UsuarioSistema(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		this.usuario = usuario;
		this.id = usuario.getIdUsuario();
		this.authorities = authorities;
	}
	

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return usuario.getSenha();
	}

	@Override
	public String getUsername() {
		return usuario.getEmail();
	}
	
}
