import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;

import com.example.demo.model.Response;
import com.example.demo.model.Systems;
import com.example.demo.model.SystemsUnavailable;
import com.example.demo.quartz.SystemRepository;
import com.example.file.WriteFile;

public class AvailabilityService {
	
	public List<Systems> Systems;
	private WriteFile wf;
	private HttpURLConnection huc;
	private URL url;
	private SystemRepository repo;
	private HashMap<String,SystemsUnavailable> unavailableMap;
	private SystemsUnavailable systemsUnavailable;
	private List<Response> res;

	public void blabla(SystemRepository repo) throws IOException {
		this.repo=repo;
		this.Systems=readDB();
	}

	public List<Systems> readDB() throws IOException {
		return repo.findAll();
	}

	public String getSystem() throws IOException, MessagingException {
		res = new ArrayList<Response>();
		this.wf = new WriteFile();
		int index = 0;
		unavailableMap = new HashMap<String,SystemsUnavailable>();
		
		while (index < this.Systems.size()) {
			try {
				int responseCode = connectionUrl(index);
				Date date = new Date();
				String systemName = this.Systems.get(index).getName();
				String systemUrl = this.url.toString();
				
				Response response= new Response(systemUrl, systemName, date, responseCode);
				res.add(response);
						
				if (400 <= responseCode) {
					StorageUnavailable(systemName,systemUrl,date);
				}
				System.out.println("responseCode " + responseCode + " Date:  " + new Date());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			index++;
		}
		wf.closeWriter();
		return insertUnavailableToEmail(unavailableMap);
	}

	public int connectionUrl(int index) throws IOException {
		this.url = new URL(this.Systems.get(index).getUrl());
		int responseCode = 200;
		try {
			this.huc = (HttpURLConnection) url.openConnection();
			responseCode = this.huc.getResponseCode();
			
			return responseCode;
		} catch (ConnectException e) {
			responseCode = 405;
			 
		}  catch ( Throwable e1) {
			
		}
		return responseCode; 
	}

	public void StorageUnavailable(String systemName,String systemUrl, Date date) throws IOException {
		systemsUnavailable=new SystemsUnavailable(systemUrl,systemName,date);
		
		wf.writeUnavailableFile(systemUrl, date, systemName);
		unavailableMap.put(systemUrl, systemsUnavailable);
	}
	
	public String insertUnavailableToEmail(HashMap<String, SystemsUnavailable> map) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Systems unavailable:");
		stringBuffer.append("<br>");
		for(String systemUrl : map.keySet()) {
			stringBuffer.append("URL: "+systemUrl+"\n");
			stringBuffer.append("<br>");
			stringBuffer.append("System Name: "+map.get(systemUrl).getName());
			stringBuffer.append("<br>");
			stringBuffer.append("Date: "+map.get(systemUrl).getDate());
			stringBuffer.append("<br>");
			stringBuffer.append("<br>");
		}
		return stringBuffer.toString();
	}


	public List<Response> getAllStatus() {
		return res;
	}
}