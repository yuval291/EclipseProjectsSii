package com.example.read_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ScannerDemo{
	
	public static void main(String[] args)  {
		String file = "system_status.txt";
	    Scanner scanner;
		try {
			scanner = new Scanner(new File(file), "UTF-8");
			 scanner.useDelimiter(",");
			    
			    while(scanner.hasNext()) {
			    	String strValue = scanner.nextLine();
			    	System.out.println(strValue);
			    	System.out.println("-----------");		    	    
//			    	String[] s = strValue.split("\\r?\\n");
			  
//			    	obj ob = new obj(s[0],s[1]);
			    }
			    
			    scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}
	
	
}