package com.adidas.consumer.service;

import java.util.List;

import com.adidas.consumer.model.Airline;
import com.adidas.consumer.model.ShortestConnectionsResponse;
import com.adidas.consumer.model.ShortestTimeResponse;

/**
 * Interface for JGrapht Service
 * @author Gaurav Kumar
 *
 */
public interface JgraphtService {
	
	/**
	 * Method for returning shortest time route using JGrapht.
	 * @param origin
	 * @param destination
	 * @param edges
	 * @return ShortestTimeResponse
	 */
	public ShortestTimeResponse getQuickestRoute (String origin, String destination, List<Airline> edges);
	
	/**
	 * Method for returning shortest path route using JGrapht.
	 * @param origin
	 * @param destination
	 * @param edges
	 * @return ShortestConnectionsResponse
	 */
	public ShortestConnectionsResponse getShortestRoute (String origin, String destination, List<Airline> edges);
}
