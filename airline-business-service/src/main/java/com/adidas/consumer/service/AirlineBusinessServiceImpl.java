package com.adidas.consumer.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adidas.consumer.model.Airline;
import com.adidas.consumer.model.AirlineRequest;
import com.adidas.consumer.model.ShortestConnectionsResponse;
import com.adidas.consumer.model.ShortestTimeResponse;

@Service
public class AirlineBusinessServiceImpl implements AirlineBusinessService{
	
    @Autowired
    private JgraphtService graphService;

    @Autowired
    private ClientService clientService;

	@Override
	public ShortestConnectionsResponse getShortestPath(
			AirlineRequest airlineRequest) {
		ShortestConnectionsResponse connectionsResponse = new ShortestConnectionsResponse();
        List<Airline> airlines = clientService.fetchAirlineData();

        if (!airlines.isEmpty()) {
            return graphService.getShortestRoute(airlineRequest.getOriginCity(), airlineRequest.getDestinyCity(), airlines);
        } else {
        	connectionsResponse.setPath(new ArrayList<>());
        }  
        return connectionsResponse;
    }

	@Override
	public ShortestTimeResponse getQuickestPath(AirlineRequest airlineRequest) {
        List<Airline> airlines = clientService.fetchAirlineData();
        ShortestTimeResponse shortestTimeResponse = new ShortestTimeResponse();
        if (!airlines.isEmpty()) {
            return graphService.getQuickestRoute(airlineRequest.getOriginCity(), airlineRequest.getDestinyCity(), airlines);
        } else {
        	shortestTimeResponse.setPath(new ArrayList<String>());
        }
        return shortestTimeResponse;
    }

}
