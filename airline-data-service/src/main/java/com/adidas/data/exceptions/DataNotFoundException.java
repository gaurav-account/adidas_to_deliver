package com.adidas.data.exceptions;

public class DataNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 3893560610831037196L;

	public DataNotFoundException(String msg){
	        super(msg);
	    }

}
