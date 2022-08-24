package com.example.project.schedular;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.example.project.Systems;

public class ReadFile{
	
	public ArrayList<Systems> Systemsii = new ArrayList<>();
	
	public ArrayList<Systems> readFile() throws IOException  {
	     String file ="system_status.txt";
	     
	     BufferedReader reader = new BufferedReader(new FileReader(file));
	     
	     String currentLine ;
	     while((currentLine = reader.readLine())!=null) {
	    	 String[] line = currentLine.split(",");
	    	 Systems sys = new Systems(line[0], line[1]);
	    	 Systemsii.add(sys);
	    	 
	     }
	     
	     reader.close();
	     return Systemsii;
	}
	
}
