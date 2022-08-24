package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadFile {
	
	public BufferedReader readFile() throws IOException {
		String file = "system_unavailable.txt";
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		System.out.println("READER"+reader.toString());
		return reader;
	}


}
