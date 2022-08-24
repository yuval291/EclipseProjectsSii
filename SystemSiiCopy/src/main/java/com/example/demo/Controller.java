package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Response;
import com.example.demo.service.SystemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class Controller {
	
	@Autowired
	private SystemService systemService;

	@PostMapping("/getSystems")
	public ResponseEntity<String> getDetailSystem() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		try {
			return new ResponseEntity<String>(mapper.writeValueAsString("Yuval its works"), HttpStatus.OK);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>(mapper.writeValueAsString("NOT WORK"),HttpStatus.BAD_REQUEST);
	}
	
	
	@PostMapping("/gogo")
	public List<Response> getAllStatus(){
		
		List<Response> res = systemService.getAllStatus();
		
		return res;	
	}
	
	

}