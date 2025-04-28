package com.reds.models.model;

import java.util.Set;

import com.reds.models.enums.RoleName;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    private RoleName roleName;

    @OneToMany(mappedBy = "role")
    private Set<UsuarioRolePermission> roles;

    public Role() {
    }

    public Role(Long idRole, RoleName roleName) {
        this.idRole = idRole;
        this.roleName = roleName;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public Set<UsuarioRolePermission> getRoles() {
        return roles;
    }

    public void setRoles(Set<UsuarioRolePermission> roles) {
        this.roles = roles;
    }
}
