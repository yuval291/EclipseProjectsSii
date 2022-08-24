package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
//@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.POST})
public class SystemController {
	
	@GetMapping("/test")
	public ResponseEntity<Void> test() {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/getSystems")
	public ResponseEntity<String> getDetailSystem() {
		
		
		ObjectMapper mapper = new ObjectMapper();

		try {
			return new ResponseEntity<String>(mapper.writeValueAsString("Yuval its works"), HttpStatus.OK);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	
	

}