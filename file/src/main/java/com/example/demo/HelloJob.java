package com.example.demo;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloJob implements Job{

	@Autowired
	private HelloService helloService = new HelloService();
	 
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		helloService.sayHello();
	}
	

}


