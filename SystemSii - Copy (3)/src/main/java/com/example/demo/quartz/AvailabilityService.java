package com.example.demo.quartz;

import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.demo.file.WriteFile;
import com.example.demo.model.BuilderResponseImpl;
import com.example.demo.model.BuilderResponseInterface;
import com.example.demo.model.DataResponse;
import com.example.demo.model.ResponseDirector;
import com.example.demo.model.Systems;
import com.example.demo.repo.SystemRepository;

@Service
public class AvailabilityService {
	
	private static final Logger logger = Logger.getLogger(AvailabilityService.class);

	private List<DataResponse> res;

	public String getSystemStatus(SystemRepository<Systems> repo) throws IOException {
		List<Systems> allSystems = repo.findAll();
		res = new ArrayList<DataResponse>();
		HashMap<String, DataResponse> unavailableMap = new HashMap<String, DataResponse>();
		WriteFile wf = new WriteFile();
		
		allSystems.forEach(sys -> {
			try {
				int responseCode = httpConnection(sys);
				Date date = new Date();
				String systemName = sys.getName();
				String systemUrl = sys.getUrl();
				
				BuilderResponseInterface builderResponse = new BuilderResponseImpl();
				ResponseDirector responseDirector = new ResponseDirector(builderResponse);
				responseDirector.createDataResponse(systemUrl, systemName, date, responseCode);
				DataResponse response = responseDirector.getDataResponse();
				res.add(response);

				if (400 <= responseCode) {
					wf.writeUnavailableFile(systemUrl, date, systemName);
					unavailableMap.put(systemUrl, response);
				}
				logger.info("responseCode " + responseCode + " Date:  " + new Date());
				
			} catch (IOException e) {
				logger.error("Error", e);
			}
		});
		return insertUnavailableToEmail(unavailableMap);
	}

	public int httpConnection(Systems sys) {
		HttpURLConnection huc;
		int responseCode = 200;
		try {
			URL url = new URL(sys.getUrl());
			huc = (HttpURLConnection) url.openConnection();
			responseCode = huc.getResponseCode();
		} catch (ConnectException e) {
			responseCode = 405;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return responseCode;
	}

	public String insertUnavailableToEmail(HashMap<String, DataResponse> map) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Systems unavailable:");
		stringBuffer.append("<br>");
		for (String systemUrl : map.keySet()) {
			stringBuffer.append("URL: " + systemUrl + "\n");
			stringBuffer.append("<br>");
			stringBuffer.append("System Name: " + map.get(systemUrl).getName());
			stringBuffer.append("<br>");
			stringBuffer.append("Date: " + map.get(systemUrl).getDate());
			stringBuffer.append("<br>");
			stringBuffer.append("<br>");
		}
		return stringBuffer.toString();
	}

	public List<DataResponse> getAllStatus() {
		res.sort(Comparator.comparing(DataResponse::getResponseCode).reversed());
		return res;
	}
}
