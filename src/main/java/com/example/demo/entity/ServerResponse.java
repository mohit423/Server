package com.example.demo.entity;

public class ServerResponse {

	private String status;

	public ServerResponse(String status) {
		this.status = status;
	}
	public ServerResponse() {
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
