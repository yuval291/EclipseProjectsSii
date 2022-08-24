package com.example.demo.quartz;

import java.io.IOException;
import java.util.HashMap;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.example.demo.email.EmailService;
import com.example.demo.model.SystemsUnavailable;
import com.example.file.ReadFile;

public class AvailabilityJob implements Job {

	@Autowired
	private AvailabilityService jobService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private SystemRepository repo;


	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			this.jobService.blabla(repo);
			String body = this.jobService.getSystem();
			this.emailService.sendEmail("yuvaldemosii@gmail.com", body, "Status Last check of unavailable systems");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}