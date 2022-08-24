package com.example.demo;

import java.util.UUID;

import org.quartz.*;

public class EmailSchedulerController {

	
	private JobDetail buildJobDetail(EmailRequest schduleEmailRequest) {
		JobDataMap jobDataMap = new JobDataMap();
		
		jobDataMap.put("email", schduleEmailRequest.getEmail());
		jobDataMap.put("subject", schduleEmailRequest.getSubject());
		jobDataMap.put("body", schduleEmailRequest.getBody());
		
		return JobBuilder.newJob(EmailJob.class)
				.withIdentity(UUID.randomUUID().toString())
				.withDescription("send Email Job")
				.usingJobData(jobDataMap)
				.storeDurably()
				.build();
	}
}
