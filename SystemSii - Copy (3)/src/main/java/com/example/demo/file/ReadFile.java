//package com.example.demo.file;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import com.example.demo.model.Systems;
//
//public class ReadFile {
//	
//	private StringBuilder stringBuilder;
//	private String line;
//
//	public ArrayList<Systems> Systemsii = new ArrayList<>();
//
//	public BufferedReader readFile() throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("system_unavailable.txt"));
//		return reader;
//	}
//
//	public ArrayList<Systems> insertToList(BufferedReader reader) throws IOException {
//		String currentLine;
//		while ((currentLine = reader.readLine()) != null) {
//			String[] line = currentLine.split(",");
//			Systems sys = new Systems(line[0], line[1]);
//			Systemsii.add(sys);
//		}
//		reader.close();
//		return Systemsii;
//	}
//
//}
