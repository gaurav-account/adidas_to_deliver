package com.adidas.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adidas.data.model.Airline;
import com.adidas.data.repo.AirlineRepository;
import com.adidas.data.service.AirlineService;

@Service
public class AirlineServiceImpl implements AirlineService {
	
	 @Autowired
	 private AirlineRepository airlineRepository;

	 @Override
	 public List<Airline> fetchAllAirlines () {
	        return (List<Airline>) airlineRepository.findAll();
	 }
	

}
