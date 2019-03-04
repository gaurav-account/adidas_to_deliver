package com.adidas.consumer.service;

import java.util.List;

import com.adidas.consumer.model.Airline;
import com.adidas.consumer.model.ShortestConnectionsResponse;
import com.adidas.consumer.model.ShortestTimeResponse;

public interface JgraphtService {
	public ShortestTimeResponse getQuickestRoute (String origin, String destination, List<Airline> edges);
	public ShortestConnectionsResponse getShortestRoute (String origin, String destination, List<Airline> edges);
}
