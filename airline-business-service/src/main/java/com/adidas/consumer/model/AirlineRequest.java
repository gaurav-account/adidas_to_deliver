package com.adidas.consumer.model;

import io.swagger.annotations.ApiModel;

@ApiModel
public class AirlineRequest {

    private String originCity;

    private String destinyCity;
   
	public String getOriginCity() {
		return originCity;
	}

	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}

	public String getDestinyCity() {
		return destinyCity;
	}

	public void setDestinyCity(String destinyCity) {
		this.destinyCity = destinyCity;
	}

	@Override
	public String toString() {
		return "Airline [ originCity=" + originCity
				+ ", destinyCity=" + destinyCity;
	}
	
	public AirlineRequest() {
	
	}

	public AirlineRequest(int id, String originCity, String destinyCity,
			String departureTime, String arrivalTime) {
		super();
		this.originCity = originCity;
		this.destinyCity = destinyCity;
	}
    
}