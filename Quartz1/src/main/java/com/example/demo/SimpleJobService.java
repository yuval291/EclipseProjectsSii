package com.example.demo;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Service;
@Service
public class SimpleJobService  {
	
	
	public void print() {
		Date date = new Date();
		System.out.println("Candidjava welcomes simple job "+date);
	}
}