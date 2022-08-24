package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Response;
import com.example.demo.quartz.AvailabilityService;

@Service
public class SystemService {

	@Autowired
	AvailabilityService availabilityService;

	public List<Response> getAllStatus() {

		return this.availabilityService.getAllStatus();
	}

}
