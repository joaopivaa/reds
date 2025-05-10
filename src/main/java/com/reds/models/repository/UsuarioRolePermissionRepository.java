package com.reds.models.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reds.models.model.Usuario;
import com.reds.models.model.UsuarioRolePermission;
import com.reds.models.model.UsuarioRolePermissionID;

public interface UsuarioRolePermissionRepository extends JpaRepository<UsuarioRolePermission, UsuarioRolePermissionID>{
	Set<UsuarioRolePermission> findByUsuario(Usuario usuario);
	
	@Query(value="SELECT urp FROM UsuarioRolePermission urp " + "WHERE urp.usuario.idUsuario =: idUsuario")
	List<UsuarioRolePermission> findUsuarioRolePermissionById(@Param("idUsuario") Long idUsuario);
}
