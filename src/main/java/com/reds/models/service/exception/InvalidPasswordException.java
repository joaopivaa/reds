package com.reds.models.service.exception;

public class InvalidPasswordException extends NegocioException {

	private static final long serialVersionUID = 8813095160072287931L;

	public InvalidPasswordException(String message) {
		super(message);
	}
}