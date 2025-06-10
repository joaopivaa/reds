package com.reds.models.model;

import java.util.Set;

import com.reds.models.enums.PermissionsName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERMISSIONS") // Se a tabela no banco chama PERMISSIONS
public class Permissions {
	private Long idPermission;
	private PermissionsName nomePermissions;
	private Set<UsuarioRolePermission> permissions;
	
	public Permissions() { }
	
	public Permissions(Long idPermission, PermissionsName nomePermissions) {
		this.idPermission = idPermission;
		this.nomePermissions = nomePermissions;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERMISSION")
	@SequenceGenerator(sequenceName = "SEQUENCIA_PERMISSION", initialValue = 1, allocationSize = 1, name = "SEQ_PERMISSION")
	public Long getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(Long idPermission) {
		this.idPermission = idPermission;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "NOME_PERMISSIONS")
	public PermissionsName getNomePermissions() {
		return nomePermissions;
	}

	public void setNomePermissions(PermissionsName nomePermissions) {
		this.nomePermissions = nomePermissions;
	}

	@OneToMany(mappedBy = "permissions")
	public Set<UsuarioRolePermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<UsuarioRolePermission> permissions) {
		this.permissions = permissions;
	}
}