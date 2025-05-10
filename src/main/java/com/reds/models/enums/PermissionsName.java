package com.reds.models.enums;

import java.util.List;

public enum PermissionsName {
	CREATE("CREATE"),
	UPDATE("UPDATE"),
	DELETE("DELETE"),
	READ("READ");
	
	private final String nomePermissions;

	private PermissionsName(String nomePermissions) {
		this.nomePermissions = nomePermissions;
	}

	public String getNomePermissions() {
		return nomePermissions;
	}
	
	public static List<String> listPermissions() {
		return List.of(
			CREATE.nomePermissions, 
			UPDATE.nomePermissions, 
			DELETE.nomePermissions, 
			READ.nomePermissions
		);
	}
	
}
