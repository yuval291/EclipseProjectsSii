package com.example.demo;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;

@RestController
public class Controller {
	
	@Autowired
	private UrlRepo urlRepo;
	
	@Autowired
	private ReportService service;


	@GetMapping
	public List<Urls> getAllUrl(){
		List<Urls> url = (List<Urls>) urlRepo.findAll();
		return url;
	}
	
	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return service.exportReport(format);
	}
	
	
}
