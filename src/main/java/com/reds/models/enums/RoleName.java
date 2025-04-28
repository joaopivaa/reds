package com.reds.models.enums;

import java.util.List;

public enum RoleName {
	ADMIN("ADMIN"),
	MANAGER("MANAGER"),
	USER("USER");
	
	private final String nomeRole;
	

	private RoleName(String nomeRole) {
		this.nomeRole = nomeRole;
	}

	public String getNomeRole() {
		return nomeRole;
	}
	
	public static List<String> listRoles(){
		return List.of(ADMIN.nomeRole, MANAGER.nomeRole, USER.nomeRole);
	}
	
	
}
