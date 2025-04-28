package com.reds.models.service.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reds.models.model.Usuario;
import com.reds.models.model.UsuarioRolePermission;
import com.reds.models.repository.UsuarioRepository;
import com.reds.models.repository.UsuarioRolePermissionRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	private UsuarioRolePermissionRepository usuarioRolePermissionRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = usuarioRepository.findUsuarioByEmail(email);
		
		if(!usuario.isPresent()){
			throw new UsernameNotFoundException("Usuario Não Cadastrado");
		}
		
		UsuarioSistema usuarioSistema = new UsuarioSistema(usuario.get(),getPermissoes(usuario.get()));
		
		return usuarioSistema;
	}

	private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
		
		Set<UsuarioRolePermission> urpList = usuarioRolePermissionRepository.findByUsuario(usuario);
		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		
		for(UsuarioRolePermission urp: urpList) {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+urp.getRole().getRoleName()));
		}
		for(UsuarioRolePermission urp: urpList) {
			authorities.add(new SimpleGrantedAuthority(urp.getPermissions().getNomePermissions().name()));
		}
		
		return authorities;
		
	}

}
