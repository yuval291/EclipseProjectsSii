package com.example.demo;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.model.Customer;
import com.example.demo.service.HotelService;

@SpringBootApplication
@ComponentScan("com.example.*")
public class Hotel3Application implements CommandLineRunner {

	@Autowired
	private HotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Hotel3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer c1 = new Customer(45645,"test","test",Date.valueOf("1995-11-29"));
		
		hotelService.addCustomer(c1);
	}

}
