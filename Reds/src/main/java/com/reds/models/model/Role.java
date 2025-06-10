package com.reds.models.model;

import java.util.Set;

import com.reds.models.enums.RoleName;

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
@Table(name = "ROLE")
public class Role {

	private Long idRole;
	private RoleName nomeRoles;
	private Set<UsuarioRolePermission> roles;
	
	public Role() {
	}
	
	public Role(Long idRole, RoleName nomeRoles) {
		this.idRole = idRole;
		this.nomeRoles = nomeRoles;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ROLE")
	@SequenceGenerator(sequenceName = "SEQ_ROLE", initialValue = 1, allocationSize = 1, name = "SEQ_ROLE")
	@Column(name = "ID_ROLE")
	public Long getIdRole() {
		return idRole;
	}
	
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "NOME_ROLE")
	public RoleName getNomeRoles() {
		return nomeRoles;
	}
	
	public void setNomeRoles(RoleName nomeRoles) {
		this.nomeRoles = nomeRoles;
	}

	@OneToMany(mappedBy = "role")
	public Set<UsuarioRolePermission> getRoles() {
		return roles;
	}

	public void setRoles(Set<UsuarioRolePermission> roles) {
		this.roles = roles;
	}
}
