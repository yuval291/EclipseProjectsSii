package com.example.demo.quartz;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Systems;
import com.example.file.ReadFile;
import com.example.file.WriteFile;

@Service
public class AvailabilityService {

	public ArrayList<Systems> Systems = new ArrayList<>();
	ReadFile rf;
	WriteFile wf;
	HttpURLConnection huc;
	URL url;

	public AvailabilityService() throws IOException {
		ReadSystemFile();
		this.wf = new WriteFile();
	}

	public void getSystem() throws IOException {
		int index = 0;

		while (index < this.Systems.size()) {
			try {
				int responseCode = connectionUrl(index);
				Date d1 = new Date();
				String systemName = this.Systems.get(index).getName();
				String systemUrl = this.url.toString();

				if (400 <= responseCode) {
					wf.writeUnavailableFile(systemUrl, d1, systemName);
				}
				System.out.println("responseCode " + responseCode);
				System.out.println("Date:  " + new Date());

			} catch (IOException e) {
				e.printStackTrace();
			}
			index++;
		}
		wf.closeWriter();

	}

	public int connectionUrl(int index) throws IOException {
		this.url = this.Systems.get(index).getUrl();
		int responseCode = 200;
		try {
			this.huc = (HttpURLConnection) url.openConnection();
			responseCode = this.huc.getResponseCode();
			return responseCode;
		} catch (ConnectException e) {
			responseCode = 405;
		}

		return responseCode;

	}

	public void ReadSystemFile() {
		this.rf = new ReadFile();
		try {
			BufferedReader reader = this.rf.readFile("1");
			this.Systems = this.rf.insertToList(reader);
			System.out.println("READE");

		} catch (IOException e) {
			System.out.println("Unable to read file");
		}
	}

}