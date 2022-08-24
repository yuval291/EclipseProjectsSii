package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface ClassRepository extends JpaRepository<Class, Integer>{

	public List<Class> findAll();
}
