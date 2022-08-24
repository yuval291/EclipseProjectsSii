package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.demo.model.DataResponse;
import com.example.demo.quartz.AvailabilityService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class SystemService {

	@Autowired
	AvailabilityService availabilityService;

	public List<DataResponse> getAllStatus() {
		return this.availabilityService.getAllStatus();
	}

	public String exportReport(List<DataResponse>systems) throws FileNotFoundException, JRException {
		File file = ResourceUtils.getFile("classpath:All_Of_Systems.jrxml");
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(systems);
		
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		Map<String, Object> map = new HashMap<>();
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, dataSource);
		
		JasperExportManager.exportReportToPdfFile(jasperPrint,"urls.pdf");
		
		return "genetated";
	}

}
