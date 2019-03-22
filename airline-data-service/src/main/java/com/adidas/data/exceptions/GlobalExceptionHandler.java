package com.adidas.data.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = {RestController.class, Service.class})
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	 @ExceptionHandler(DataNotFoundException.class)
	 public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException e) {
		 return ResponseEntity.badRequest().body(e.getMessage());
	 }
}
