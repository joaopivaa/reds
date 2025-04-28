package com.reds.models.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO_ROLE_PERMISSION")
public class UsuarioRolePermission {
	private UsuarioRolePermissionID id;
	
	private Usuario usuario;
	private Role role;
	private Permissions permissions;
	public UsuarioRolePermission() {
		
	}
	public UsuarioRolePermission(UsuarioRolePermissionID id, Usuario usuario, Role role, Permissions permissions) {
		this.id = id;
		this.usuario = usuario;
		this.role = role;
		this.permissions = permissions;
	}
	@EmbeddedId
	public UsuarioRolePermissionID getId() {
		return id;
	}
	public void setId(UsuarioRolePermissionID id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO",insertable = false, updatable = false, nullable = false)
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@ManyToOne
	@JoinColumn(name = "ID_ROLE",insertable = false, updatable = false, nullable = false)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@ManyToOne
	@JoinColumn(name = "ID_PERMISSION",insertable = false, updatable = false, nullable = false)
	public Permissions getPermissions() {
		return permissions;
	}
	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}
	
}
