package com.example.project.schedular;

import java.io.IOException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class SystemJob implements Job{
	
	@Autowired
	private JobService jobService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			this.jobService=new JobService();
			this.jobService.getSystem();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}