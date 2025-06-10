package com.reds.models.service.security;

import com.reds.models.service.exception.NegocioException;

public class AccessForbiddenException extends NegocioException {
	
	private static final long serialVersionUID = -1L;
	
	public AccessForbiddenException(String message) {
		super(message);
	}
}
