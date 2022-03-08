package com.eduardo.helpdesk.domain;

public class CampoInvalidoException extends RuntimeException{
	public CampoInvalidoException(String message) {
		super(message);
	}
}
