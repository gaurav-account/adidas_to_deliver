package com.adidas.consumer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adidas.consumer.exceptions.DataNotFoundException;
import com.adidas.consumer.model.Airline;
import com.adidas.consumer.model.AirlineRequest;
import com.adidas.consumer.model.ShortestConnectionsResponse;
import com.adidas.consumer.model.ShortestTimeResponse;

/**
 * Implementation Class for Airline Business Service
 * @author Gaurav Kumar
 *
 */
@Service
public class AirlineBusinessServiceImpl implements AirlineBusinessService{
	
    @Autowired
    private JgraphtService graphService;

    @Autowired
    private ClientService clientService;

	/* (non-Javadoc)
	 * @see com.adidas.consumer.service.AirlineBusinessService#getShortestPath(com.adidas.consumer.model.AirlineRequest)
	 */
	@Override
	public ShortestConnectionsResponse getShortestPath(
			AirlineRequest airlineRequest) {
        List<Airline> airlines = clientService.fetchAirlineData();

        if (!airlines.isEmpty()) {
            return graphService.getShortestRoute(airlineRequest.getOriginCity(), airlineRequest.getDestinyCity(), airlines);
        } else {
        	throw new DataNotFoundException("Couln't fetch airline data");
        }  
    }

	/* (non-Javadoc)
	 * @see com.adidas.consumer.service.AirlineBusinessService#getQuickestPath(com.adidas.consumer.model.AirlineRequest)
	 */
	@Override
	public ShortestTimeResponse getQuickestPath(AirlineRequest airlineRequest) {
        List<Airline> airlines = clientService.fetchAirlineData();
        if (!airlines.isEmpty()) {
            return graphService.getQuickestRoute(airlineRequest.getOriginCity(), airlineRequest.getDestinyCity(), airlines);
        } else {
        	throw new DataNotFoundException("Couln't fetch airline data");
        }
    }

}
