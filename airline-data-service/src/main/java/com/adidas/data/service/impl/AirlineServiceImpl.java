package com.adidas.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adidas.data.model.Airline;
import com.adidas.data.repo.AirlineRepository;
import com.adidas.data.service.AirlineService;

/**
 * Service Class of Airline Data
 * @author Gaurav Kumar
 *
 */
@Service
public class AirlineServiceImpl implements AirlineService {
	
	 @Autowired
	 private AirlineRepository airlineRepository;

	 /* Service method to return list of airlines.
	 * @see com.adidas.data.service.AirlineService#fetchAllAirlines()
	 */
	@Override
	 public List<Airline> fetchAllAirlines () {
	        return (List<Airline>) airlineRepository.findAll();
	 }
	

}
