package com.example.demo.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class SystemsUnavailable {
	
	String url;
	String name;
	Date date;
	
	public SystemsUnavailable(String url, String name, Date date) {
		super();
		this.url = url;
		this.name = name;
		this.date = date;
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
	
	

}
