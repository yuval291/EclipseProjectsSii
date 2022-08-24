package com.example.demo.model;

import java.util.Date;

public class BuilderResponseImpl implements BuilderResponseInterface {
	
	private DataResponse dataResponse;

	public BuilderResponseImpl() {
		this.dataResponse = new DataResponse() ;
	}

	@Override
	public void buildUrlResponse(String url) {
		dataResponse.setUrl(url);
	}

	@Override
	public void buildNameResponse(String name) {
		dataResponse.setName(name);
	}

	@Override
	public void buildDateResponse(Date date) {
		dataResponse.setDate(date);
	}

	@Override
	public void buildCodeResponse(int responseCode) {
		dataResponse.setResponseCode(responseCode);
	}

	@Override
	public DataResponse getDataResponse() {
		return this.dataResponse;
	}

}
