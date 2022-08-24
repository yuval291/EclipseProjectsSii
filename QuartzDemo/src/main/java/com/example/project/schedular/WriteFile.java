package com.example.project.schedular;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.example.project.Systems;

public class WriteFile{
	
	public File file;
	private BufferedWriter writer;
	
	public WriteFile() throws IOException {
		this.file = CreatingFile_thenCorrect();
		FileWriter fWriter = new  FileWriter("system_unavailable.txt",true);
		this.writer = new BufferedWriter(fWriter);
	}

	public void writeUnavailableFile(String url, Date date , String name) throws IOException  {
	    writer.append("URL System: "+ url + "\n");
	    writer.append("DATE: "+ date + "\n");
	    writer.append("SYSTEM: "+ name + "\n");
	    writer.append("\n"); 
	}
	
	public static File CreatingFile_thenCorrect() throws IOException {
		File newFile = new File("system_unavailable.txt");
		
		if(!newFile.exists()) {
			System.out.println("File does not exist, creates new one");
			newFile.createNewFile();
			System.out.println("The file was created successfully");
		}
		return newFile;
	}

	public void closeWriter() throws IOException {
		 this.writer.close();
	}

}
