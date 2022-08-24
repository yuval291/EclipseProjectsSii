package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DbProjectDemo1Application implements CommandLineRunner {


	
	@Autowired
	private service service;
	
	public static void main(String[] args) {
		SpringApplication.run(DbProjectDemo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		String sql="INSERT INTO new_table (id,fullname,email,password) VALUES (?,?,?,?)";
//		int res = jdbcTemplate.update(sql,"8879","ariel","ariel@gmail.com","888");
//		
//		if(res>0) {
//			System.out.println("A new row has been inserted");
//		}
		service.getSystems();
		
	}

}
