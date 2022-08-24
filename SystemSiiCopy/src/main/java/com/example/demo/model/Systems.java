package com.example.demo.model;

import java.net.MalformedURLException;
import java.net.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "url_systems")
public class Systems {
	@Id
	@Column(name = "url")
	String url;
	@Column(name = "name")
	String name;
	
	public Systems() {}
	
	public Systems(String url , String name) {
		this.name =name;
		this.url = url;
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