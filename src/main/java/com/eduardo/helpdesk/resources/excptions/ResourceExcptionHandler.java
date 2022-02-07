package com.eduardo.helpdesk.resources.excptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.eduardo.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.eduardo.helpdesk.services.exceptions.ObjectnotFoundException;

@ControllerAdvice
public class ResourceExcptionHandler {
	
	// Criamos aqui um manipulador de excessões para o ObjectnotFoundException
	@ExceptionHandler(ObjectnotFoundException.class)
	public ResponseEntity<StandardError> objectnotFoundException(ObjectnotFoundException ex,HttpServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				"Object Not Found", ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	// Criamos aqui um manipulador de excessões para o DataIntegrityViolationException
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> objectnotFoundException(DataIntegrityViolationException ex,HttpServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Violação de dados", ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
