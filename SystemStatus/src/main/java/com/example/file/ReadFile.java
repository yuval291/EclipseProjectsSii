package com.example.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.cache.annotation.Cacheable;
import com.example.demo.Systems;

public class ReadFile{
	
	public ArrayList<Systems> Systemsii = new ArrayList<>();
	
	
	public BufferedReader readFile(String id) throws IOException  {
	     String file ="system_status.txt";
	     BufferedReader reader = new BufferedReader(new FileReader(file));
	     System.out.println("BufferedReader reader");
	     return reader;
	}
	 
	 public ArrayList<Systems> insertToList(BufferedReader reader) throws IOException {
		 String currentLine;
		 while((currentLine = reader.readLine())!=null) {
	    	 String[] line = currentLine.split(",");
	    	 Systems sys = new Systems(line[0], line[1]);
	    	 Systemsii.add(sys);
	    	 
	     }
		 
		 reader.close();
		 return Systemsii;
	}
	
}