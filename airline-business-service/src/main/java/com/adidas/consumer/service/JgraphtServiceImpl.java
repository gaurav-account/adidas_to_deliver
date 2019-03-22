package com.adidas.consumer.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.BellmanFordShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.adidas.consumer.exceptions.InvalidDataException;
import com.adidas.consumer.model.Airline;
import com.adidas.consumer.model.ShortestConnectionsResponse;
import com.adidas.consumer.model.ShortestTimeResponse;
import java.util.function.Function;

/**
 * Implementation class for jgrapht service. Using BellmanFordShortestPath algorithm
 * @author Gaurav Kumar
 *
 *
 */
@Service
public class JgraphtServiceImpl implements JgraphtService {

	/* (non-Javadoc)
	 * @see com.adidas.consumer.service.JgraphtService#getQuickestRoute(java.lang.String, java.lang.String, java.util.List)
	 */
	@Override
	public ShortestTimeResponse getQuickestRoute(String origin,
			String destination, List<Airline> edges) {
		//1. Build Weighed Graph on Cities
		SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph = buildWeighedGraph(getCities(edges), edges, quickestRoute());

		ShortestTimeResponse pathResponse = new ShortestTimeResponse();
		//2. Validate Graph
		if (validateGraph(origin, destination, graph)) {
			//3. Find short time path using BellmanFordShortestPath algorithm.
			GraphPath<String, DefaultWeightedEdge> pathBetween = BellmanFordShortestPath.findPathBetween(graph, origin, destination);

			pathResponse.setPath(pathBetween.getVertexList());

		} else {
			pathResponse.setPath(new ArrayList<>());

		}
		return pathResponse;
	}

	/* (non-Javadoc)
	 * @see com.adidas.consumer.service.JgraphtService#getShortestRoute(java.lang.String, java.lang.String, java.util.List)
	 */
	@Override
	public ShortestConnectionsResponse getShortestRoute(String origin,
			String destination, List<Airline> edges) {
		//1. Build Weighed Graph on Cities
		SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph = buildWeighedGraph(getCities(edges), edges, shortestRoute());

		ShortestConnectionsResponse pathResponse = new ShortestConnectionsResponse();
		//2. Validate Graph
		if (validateGraph(origin, destination, graph)) {
			//3. Find shortest path using BellmanFordShortestPath algorithm.
			GraphPath<String, DefaultWeightedEdge> pathBetween = BellmanFordShortestPath.findPathBetween(graph, origin, destination);

			pathResponse.setPath(pathBetween.getVertexList());
			
		} else {
			pathResponse.setPath(new ArrayList<>());
		}

		return pathResponse;
	}

	private List<String> getCities(List<Airline> edges) {
		Set<String> cities = new HashSet<>();

		for (Airline airline : edges) {
			cities.add(airline.getOriginCity());
			cities.add(airline.getDestinyCity());
		}
		return new ArrayList<>(cities);
	}

	private boolean validateGraph(String origin, String destination,
			SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph) {
		return graph.containsVertex(origin)
				&& graph.containsVertex(destination);
	}

	private SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> buildWeighedGraph(List<String> nodes, List<Airline> edges, Function<Airline, Long> edgeFunction) {
		SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

		nodes.forEach(node -> graph.addVertex(node));

		for (Airline airline : edges) {
			Long weight = edgeFunction.apply(airline);

			if (weight > 0) {
				DefaultWeightedEdge e1 = graph.addEdge(airline.getOriginCity(),airline.getDestinyCity());
				graph.setEdgeWeight(e1, weight);
			}else{
				throw new InvalidDataException("Error occured while calculating edge weight");
			}
		}
		return graph;
	}
	
    private Function<Airline, Long> quickestRoute()  {
        return (Airline airline) -> calculateTimeDifference(airline.getDepartureTime(), airline.getArrivalTime());
    }

    private Function<Airline, Long> shortestRoute() {
        return (Airline airline) -> 1L;
    }
    
    private long calculateTimeDifference(String departureTime, String arrivalTime) {

        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        	LocalDateTime dep = LocalDateTime.parse(departureTime, formatter);
        	LocalDateTime arr = LocalDateTime.parse(arrivalTime, formatter);
        	
        	if(arr.isBefore(dep)){
        		arr = arr.plusDays(1);
        	}
        	Duration duration = Duration.between(dep, arr);
        	return duration.toMillis();
        
    }
    
}
