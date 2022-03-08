package com.eduardo.helpdesk.domain;

public class CampoInvalidoException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public CampoInvalidoException(String message) {
		super(message);
	}
}
