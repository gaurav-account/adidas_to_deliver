package com.adidas.consumer.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exception Handler class to catch custom exceptions and return exception message in response.
 * @author Gaurav Kumar
 *
 */
@ControllerAdvice(annotations = {RestController.class, Service.class})
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	 /**
	  * Handler method for DataNotFoundException.
	 * @param e
	 * @return ResponseEntity
	 */
	@ExceptionHandler(DataNotFoundException.class)
	 public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException e) {
		 return ResponseEntity.badRequest().body(e.getMessage());
	 }
	 /**
	  * Handler method for InvalidDataException.
	 * @param e
	 * @return ResponseEntity
	 */
	@ExceptionHandler(InvalidDataException.class)
	 public ResponseEntity<Object> handleInvalidDataException(InvalidDataException e) {
		 return ResponseEntity.badRequest().body(e.getMessage());
	 }
}
