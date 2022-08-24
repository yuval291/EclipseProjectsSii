package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Customer;
import com.example.demo.model.Room;

public interface CustomerRepository  extends JpaRepository<Customer, Integer>{

}
