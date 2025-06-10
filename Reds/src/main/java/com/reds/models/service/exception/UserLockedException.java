package com.reds.models.service.exception;

public class UserLockedException extends NegocioException {
	
	private static final long serialVersionUID = 2158908184385248180L;

	public UserLockedException(String message) {
		super(message);
	}
}
