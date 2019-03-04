package com.adidas.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;


@Entity
@ApiModel
@Table(name = "airline")
public class Airline {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ApiModelProperty(value = "City")
    @Column(name = "city")
    private String originCity;

    @ApiModelProperty(value = "Destiny city")
    @Column(name = "destiny_city")
    private String destinyCity;

    @ApiModelProperty(value = "Departure time.")
    @Column(name = "departure_time")
    private String departureTime;

    @ApiModelProperty(value = "Arrival time.")
    @Column(name = "arrival_time")
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