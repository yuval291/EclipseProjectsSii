package com.example.demo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sii_systems")
public class Systems {
	@Id
	@Column(name = "url")
	String url;
	@Column(name = "name")
	String name;
	@Column(name = "date")
	Date date;
	@Column(name = "response_code")
	Integer responseCode;
	
	public Systems() {}
	
	public Systems(String url , String name) {
		this.name =name;
		this.url = url;
	}

	public Systems(String url, String name, Date date, int responseCode) {
		super();
		this.url = url;
		this.name = name;
		this.date = date;
		this.responseCode = responseCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}