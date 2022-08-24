package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "url_systems")
public class Urls {

	@Id
	@Column(name = "url")
	String url;
	@Column(name = "name")
	String name;
	
	public Urls() {}
	
	public Urls(String url , String name) {
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
