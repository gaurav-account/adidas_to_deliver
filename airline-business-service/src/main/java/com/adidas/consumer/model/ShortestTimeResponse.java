package com.adidas.consumer.model;

import java.util.List;

public class ShortestTimeResponse {
	
	private List<String> path;
	
	public ShortestTimeResponse(List<String> path) {
		super();
		this.path = path;
	}

	public ShortestTimeResponse() {
		super();
	}

	@Override
	public String toString() {
		return "ShortestTimeResponse [path=" + path + "]";
	}

	public List<String> getPath() {
		return path;
	}

	public void setPath(List<String> path) {
		this.path = path;
	}


}
