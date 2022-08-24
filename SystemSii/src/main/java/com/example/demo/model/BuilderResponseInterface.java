package com.example.demo.model;

import java.util.Date;

public interface BuilderResponseInterface {

	public void buildUrlResponse(String url);

	public void buildNameResponse(String name);
	
	public void buildDateResponse(Date date);
	
	public void buildCodeResponse(int responseCode);

	public DataResponse getDataResponse();

}
