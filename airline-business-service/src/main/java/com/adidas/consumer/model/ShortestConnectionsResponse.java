package com.adidas.consumer.model;

import java.util.List;

/**
 * POJO class for Response with shortest connection.
 * @author Gaurav Kumar
 *
 */
public class ShortestConnectionsResponse {
	private List<String> path;

	public List<String> getPath() {
		return path;
	}

	public void setPath(List<String> path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ShortestConnectionsResponse [path=" + path + "]";
	}

	public ShortestConnectionsResponse(List<String> path) {
		super();
		this.path = path;
	}

	public ShortestConnectionsResponse() {
		super();
	}
	
}
