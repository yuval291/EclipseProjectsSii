package com.example.demo.quartz;

import java.io.IOException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class AvailabilityJob implements Job{
	
	@Autowired
	private AvailabilityService jobService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			this.jobService=new AvailabilityService();
			System.out.println("doing something");
			this.jobService.getSystem();
			System.out.println("doing something");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}