package com.example.demo.file;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
public class WriteFile {

	public void writeUnavailableFile(String url, Date date , String name) throws IOException  {
		FileWriter fWriter = new  FileWriter("system_unavailable.txt",true);
		BufferedWriter writer = new BufferedWriter(fWriter);
	    writer.append("URL System: "+ url + "\n");
	    writer.append("DATE: "+ date + "\n");
	    writer.append("SYSTEM: "+ name + "\n");
	    writer.append("\n"); 
	    
	    writer.close();
 
	}

}
