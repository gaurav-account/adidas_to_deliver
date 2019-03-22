package com.adidas.consumer.model;

import io.swagger.annotations.ApiModel;

/**
 * POJO class for Airline data.
 * @author Gaurav Kumar
 *
 */
@ApiModel
public class Airline {
    private int id;

    private String originCity;

    private String destinyCity;
    
    private String departureTime;

    private String arrivalTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "Airline [id=" + id + ", originCity=" + originCity
				+ ", destinyCity=" + destinyCity + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + "]";
	}
	
	public Airline() {
	
	}

	public Airline(int id, String originCity, String destinyCity,
			String departureTime, String arrivalTime) {
		super();
		this.id = id;
		this.originCity = originCity;
		this.destinyCity = destinyCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
    
}