package com.example.demo.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	JavaMailSender mailSender;
	

	public void sendEmail(String toEmail, String body, String subject) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			
			mimeMessageHelper.setFrom("yuval_el@sii.org.il");
			mimeMessageHelper.setTo(toEmail);
			mimeMessageHelper.setText(body, true);
			mimeMessageHelper.setSubject(subject);

			mailSender.send(mimeMessageHelper.getMimeMessage());
			System.out.println("Mail send...");

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Mail NOT Send...");
		}
	}

	public void sendEmailwithAttachment(String toEmail, String body, String subject, String attachment) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

			mimeMessageHelper.setFrom("yuval_el@sii.org.il");
			mimeMessageHelper.setTo(toEmail);
			mimeMessageHelper.setText(body, true);
			mimeMessageHelper.setSubject(subject);

			FileSystemResource fileSystem = new FileSystemResource(new File(attachment));

			mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);

			mailSender.send(mimeMessageHelper.getMimeMessage());
			System.out.println("Mail Send...");

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Mail NOT Send...");
		}

	}

}
