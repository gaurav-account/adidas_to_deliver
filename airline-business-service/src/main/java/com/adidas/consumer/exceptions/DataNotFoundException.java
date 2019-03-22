package com.adidas.consumer.exceptions;

/**
 * Custom Exception Class Created for the scenario when there data does not exist.
 * @author Gaurav Kumar
 *
 */
public class DataNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -5281697725203693621L;

	public DataNotFoundException(String msg){
	        super(msg);
	    }

}
