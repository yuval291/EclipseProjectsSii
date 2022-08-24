package com.example.read_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BufferedReaderDemo{
	
	public static void main(String[] args) throws IOException  {
	     String file ="system_status.txt";
	     
	     BufferedReader reader = new BufferedReader(new FileReader(file));
	     
	     String currentLine ;
	     while((currentLine = reader.readLine())!=null) {
	    	 System.out.println(currentLine);
	    	 System.out.println("******");
	     }
	     
	     reader.close();
	}
	
}
