package com.adidas.consumer.exceptions;

/**
 * Custom Exception Class Created for the scenario when input data is invalid.
 * @author Gaurav Kumar
 *
 */
public class InvalidDataException extends RuntimeException {
	
	private static final long serialVersionUID = 3992767585509513660L;

	public InvalidDataException(String msg){
	        super(msg);
	    }

}
