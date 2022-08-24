package com.example.write_file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class BufferedWriterFile{
	
	public static void main(String[] args) throws IOException {
		
		File file = givenUsingNio_whenCreatingFile_thenCorrect();
		String str = "Hello";
	    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	    writer.write(str);
			    
	    writer.close();
	}
	
	public static File givenUsingNio_whenCreatingFile_thenCorrect() throws IOException {
		File newFile = new File("hello.txt");
		if(!newFile.exists()) {
			System.out.println("File does not exist, creates new one");
			newFile.createNewFile();
			System.out.println("The file was created successfully");
		}
		return newFile;
	}
	
}