package com.adidas.consumer.service;

import com.adidas.consumer.model.AirlineRequest;
import com.adidas.consumer.model.ShortestConnectionsResponse;
import com.adidas.consumer.model.ShortestTimeResponse;

public interface AirlineBusinessService {

	public ShortestConnectionsResponse getShortestPath(AirlineRequest airlineRequest);
	public ShortestTimeResponse getQuickestPath(AirlineRequest airlineRequest);
}
