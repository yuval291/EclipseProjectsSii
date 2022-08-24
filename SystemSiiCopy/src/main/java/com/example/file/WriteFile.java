package com.example.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class WriteFile {

	public File file;
	private BufferedWriter writer;
	
	public WriteFile() throws IOException {
		FileWriter fWriter = new  FileWriter("system_unavailable.txt",true);
		this.writer = new BufferedWriter(fWriter);
	}

	public void writeUnavailableFile(String url, Date date , String name) throws IOException  {
	    writer.append("URL System: "+ url + "\n");
	    writer.append("DATE: "+ date + "\n");
	    writer.append("SYSTEM: "+ name + "\n");
	    writer.append("\n"); 
 
	}

	public void closeWriter() throws IOException {
		 this.writer.close();
	}

}
