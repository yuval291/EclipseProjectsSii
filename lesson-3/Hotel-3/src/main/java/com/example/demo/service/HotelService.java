package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RoomRepository;

@Service
public class HotelService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private RoomRepository roomRepo;
	
	public void addCustomer(Customer c1) {
		customerRepo.save(c1);
	}

}
