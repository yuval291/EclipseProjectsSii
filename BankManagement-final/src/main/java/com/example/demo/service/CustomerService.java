package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Customer;
import com.example.demo.repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Transactional
	public Customer addCustomer(Customer newCustomer) {
		return customerRepo.save(newCustomer);
	}

	@Transactional
	public List<Customer> findAllCustomer() {
		return customerRepo.findAll();
	}

	@Transactional
	public Optional<Customer> findById(Long customerId) {
		return customerRepo.findById(customerId);
	}

	@Transactional
	public void deleteById(Long customerId) {
		customerRepo.deleteById(customerId);
	}

	@Transactional
	public void updateCustomer(Customer updateCustomer) {
		customerRepo.save(updateCustomer);
	}
}
