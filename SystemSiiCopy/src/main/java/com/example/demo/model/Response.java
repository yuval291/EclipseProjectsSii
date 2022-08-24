package com.example.demo.model;

import java.util.Date;

public class Response {

	String url;
	String name;
	Date date;
	int responseCode;
	
	
	public Response(String url, String name, Date date, int responseCode) {
		super();
		this.url = url;
		this.name = name;
		this.date = date;
		this.responseCode = responseCode;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
