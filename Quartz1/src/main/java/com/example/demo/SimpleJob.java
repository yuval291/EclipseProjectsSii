package com.example.demo;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

public class SimpleJob implements Job {
	
	@Autowired
	SimpleJobService simpleJobService;
	
	@Override
	public void execute(JobExecutionContext jobExecutionContext) {
//		this.simpleJobService=new SimpleJobService();
		this.simpleJobService.print();
	}
}