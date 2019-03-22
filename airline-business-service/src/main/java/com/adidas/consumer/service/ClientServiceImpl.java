package com.adidas.consumer.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestTemplate;
import com.adidas.consumer.model.Airline;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Implementation class for interface Client Service.
 * @author Gaurav Kumar
 *
 */
@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
    protected RestTemplate restTemplate;

    @Value("${airlineService.endpoint:http://AIRLINE-DATA-SERVICE}")
    private String AIRLINE_SERVICE_URL;

    @Value("${airlineData.endpoint:/airlines}")
    private String AIRLINE_ENDPOINT;

	/* (non-Javadoc)
	 * @see com.adidas.consumer.service.ClientService#fetchAirlineData()
	 */
	@Override
	@HystrixCommand(fallbackMethod = "emptyAirlines")
	public List<Airline> fetchAirlineData() {
        ResponseEntity<List<Airline>> response = restTemplate.exchange(
        		AIRLINE_SERVICE_URL + AIRLINE_ENDPOINT,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Airline>>(){});
        return response.getBody();
    }
	
    public List<Airline> emptyAirlines() {
        return new ArrayList<>();
    }
}
