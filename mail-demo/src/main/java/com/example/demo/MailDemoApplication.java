package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MailDemoApplication {

	@Autowired
	private MailServiceImplS service;

	private ReadFile rf;

	public static void main(String[] args) {
		SpringApplication.run(MailDemoApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException, IOException {

		this.rf = new ReadFile();
		BufferedReader reader = this.rf.readFile();
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append("\n");
			System.out.println(line);
			System.out.println("----------");
		}

		String str = stringBuilder.toString();
//		System.out.println("STR==="+str);

		service.sendEmailwithAttachment("yuvaldemosii@gmail.com", str,
				"bla bla bla ......", "C:\\Users\\u40881\\eclipse-workspace\\SystemSii\\system_status.txt");
	}

}
