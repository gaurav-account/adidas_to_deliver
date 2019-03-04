package com.adidas.data.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.data.model.Airline;
import com.adidas.data.service.AirlineService;

@RestController
@Api(value = "Users microservice", description = "This API has a CRUD for users")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @ApiOperation(
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "All Airlines Data",
            notes="List of Airline")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Internal Error")}
    )
    @GetMapping("/airlines")
    public List<Airline> fetchAllAirlines() {
    	List<Airline> airlines = new ArrayList<Airline>();
    	airlines = airlineService.fetchAllAirlines();
        return airlines;
    }

}
