package com.example.demo.model;

import java.util.Date;

public class ResponseDirector {
	
	private BuilderResponseInterface builderResponse;

	public ResponseDirector(BuilderResponseInterface builderResponse) {
		this.builderResponse = builderResponse;
	}
	
	public DataResponse getDataResponse() {
		return this.builderResponse.getDataResponse();
	}
	
	public void createDataResponse(String url, String name, Date date, int responseCode) {
		this.builderResponse.buildUrlResponse(url);
		this.builderResponse.buildNameResponse(name);
		this.builderResponse.buildCodeResponse(responseCode);
		this.builderResponse.buildDateResponse(date);
	}

}
