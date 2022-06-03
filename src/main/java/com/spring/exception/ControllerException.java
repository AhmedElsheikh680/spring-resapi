package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {

	
	@ExceptionHandler
	public ResponseEntity<StudentError> getExceptionNotFound(StudentException studentException) {
		StudentError studentError = new StudentError();
		studentError.setStatuscode(HttpStatus.NOT_FOUND.value());
		studentError.setMessage(studentException.getMessage());
		studentError.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentError>(studentError, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<StudentError> getException(Exception e) {
		StudentError studentError = new StudentError();
		studentError.setStatuscode(HttpStatus.BAD_REQUEST.value());
		studentError.setMessage(e.getMessage());
		studentError.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<StudentError>(studentError, HttpStatus.BAD_REQUEST);
	}
}
