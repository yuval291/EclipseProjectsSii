package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;


@SpringBootApplication
@ComponentScan("com.example.*")
public class Yad2Application {
	
	@Autowired
	private CarService carService;

	public static void main(String[] args) {
		SpringApplication.run(Yad2Application.class, args);
	}

}
