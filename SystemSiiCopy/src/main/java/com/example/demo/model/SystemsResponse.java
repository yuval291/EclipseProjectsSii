package com.example.demo.model;

import java.util.Date;

public class SystemsResponse {

	Date date;
	int responseCode;
	
	public SystemsResponse(Date date, int responseCode) {
		super();
		this.date = date;
		this.responseCode = responseCode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	
	
	
}
