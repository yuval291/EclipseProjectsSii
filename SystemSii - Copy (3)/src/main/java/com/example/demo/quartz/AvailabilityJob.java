package com.example.demo.quartz;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Systems;
import com.example.demo.repo.SystemRepository;
import com.example.demo.service.EmailService;


public class AvailabilityJob implements Job {

	@Autowired
	private AvailabilityService jobService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private SystemRepository<Systems> repo;
	
	private static final Logger logger = Logger.getLogger(AvailabilityJob.class);


	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			String body = this.jobService.getSystemStatus(repo);
			this.emailService.sendEmail("yuvaldemosii@gmail.com", body, "Status Last check of unavailable systems");
		} catch (IOException e) {
			logger.error(e);
		}
	}

}