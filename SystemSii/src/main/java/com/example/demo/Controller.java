package com.example.demo;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DataResponse;
//import com.example.demo.model.Systems;
import com.example.demo.service.SystemService;

import net.sf.jasperreports.engine.JRException;

@RestController
public class Controller {
	
	@Autowired
	private SystemService systemService;
	
	@GetMapping("/")
	public List<DataResponse> getAllStatus(){
		List<DataResponse> res = systemService.getAllStatus();
 		return res;	
	}
	
	@PostMapping("/export-pdf")
	public Boolean generatePdfReport(@RequestBody List<DataResponse> systems) throws FileNotFoundException, JRException {
		boolean succses = true;
		if(systems==null) {
			succses = false;
		}
		systemService.exportReport(systems);
		return true;
	}
	
	

}