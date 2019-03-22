package com.adidas.consumer.service;

import com.adidas.consumer.model.AirlineRequest;
import com.adidas.consumer.model.ShortestConnectionsResponse;
import com.adidas.consumer.model.ShortestTimeResponse;

/**
 * Interface for Airline Business Service.
 * @author Gaurav Kumar
 *
 */
public interface AirlineBusinessService {

	/**
	 * Returns the shortest connection path.
	 * @param airlineRequest
	 * @return ShortestConnectionsResponse
	 */
	public ShortestConnectionsResponse getShortestPath(AirlineRequest airlineRequest);
	/**
	 * Returns the shortest time path.
	 * @param airlineRequest
	 * @return ShortestTimeResponse
	 */
	public ShortestTimeResponse getQuickestPath(AirlineRequest airlineRequest);
}
