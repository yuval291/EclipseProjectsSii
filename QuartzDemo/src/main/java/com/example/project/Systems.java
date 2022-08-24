package com.example.project;

import java.net.MalformedURLException;
import java.net.URL;

public class Systems {
	
	String name;
	URL url;
	
	public Systems(String url , String name) {
		this.name =name;
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}
	
	
	
	
	
}