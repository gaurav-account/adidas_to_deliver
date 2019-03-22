package com.adidas.consumer.service;

import java.util.List;

import com.adidas.consumer.model.Airline;

/**
 * Interface for Client Service
 * @author Gaurav Kumar
 *
 */
public interface ClientService {
	
	/**
	 * This method fetch all airline data.
	 * @return List<Airline>
	 */
	public List<Airline> fetchAirlineData() ;
}
