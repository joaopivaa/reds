package com.reds.models.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reds.models.model.Usuario;
import com.reds.models.model.UsuarioRolePermission;
import com.reds.models.model.UsuarioRolePermissionID;

public interface UsuarioRolePermissionRepository extends JpaRepository<UsuarioRolePermission, UsuarioRolePermissionID>{
	Set<UsuarioRolePermission> findByUsuario(Usuario usuario);
	
}
