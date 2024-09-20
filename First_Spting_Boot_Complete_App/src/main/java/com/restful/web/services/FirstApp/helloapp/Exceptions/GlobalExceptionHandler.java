package com.restful.web.services.FirstApp.helloapp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

//@RestControllerAdvice
public class GlobalExceptionHandler {
//	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGlobalException(Exception ex,WebRequest request) {
		System.out.println(" <<<<<<<< inside GlobalExceptionHandler >>>> ");
		return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
	}
	//@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleGlobalException(MethodArgumentNotValidException ex,WebRequest request) {
		System.out.println(" <<<<<<<< inside MethodArgumentNotValidException >>>> ");
		return new ResponseEntity<>("An unexpected error occurred: " + ex.getFieldErrors(), HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
	}
}
