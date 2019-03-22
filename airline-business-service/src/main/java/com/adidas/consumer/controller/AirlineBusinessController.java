package com.adidas.consumer.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.adidas.consumer.model.AirlineRequest;
import com.adidas.consumer.model.ShortestConnectionsResponse;
import com.adidas.consumer.model.ShortestTimeResponse;
import com.adidas.consumer.service.AirlineBusinessService;

/**
 * Controller Class for Airline Business Service.
 * This class has two apis
 * 1./shortestTime returns the shortest time path
 * 2./shortestConnection returns the shortest connection path
 * @author Gaurav Kumar
 *
 */
@RestController
public class AirlineBusinessController {
	
	  @Autowired
	  private AirlineBusinessService airlineBusinessService;
	  
	  
	    /**
	     * This API takes airline origin and destiny city as input and returns list of cities in shortest time path
	     * @param airlineRequest
	     * @return ShortestTimeResponse
	     */
	    @ApiOperation(
	    		consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE,
	            value = "List the shortest time path",
	            notes="List of Airline")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successful request"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 500, message = "Internal Error")}
	    )
	  @PostMapping("/shortestTime")
	  public ShortestTimeResponse shortestTime(@Valid @RequestBody AirlineRequest airlineRequest) {
	      return airlineBusinessService.getQuickestPath(airlineRequest);
	  }

	  
	    /**
	     * This API takes airline origin and destiny city as input and returns list of cities in shortest connection path
	     * @param airlineRequest
	     * @return ShortestConnectionsResponse
	     */
	    @ApiOperation(
	    		consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE,
	            value = "List the shortest connection path",
	            notes="List of Airline")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successful request"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 500, message = "Internal Error")}
	    )
	  @PostMapping("/shortestConnection")
	  public ShortestConnectionsResponse shortestConnection(@Valid @RequestBody AirlineRequest airlineRequest) {
	      return airlineBusinessService.getShortestPath(airlineRequest);
	  }

}
