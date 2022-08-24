package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface StudentRepository extends JpaRepository<Student, Integer>{

	public List<Student> findAll();
	
	public List<Student> findByClassId(Class c);

	@Query(value = "select * from student where average>85", nativeQuery = true)
	public List<Student> getExcelentStudents();
	
	@Query(value = "select * from student where average<60", nativeQuery = true)
	public List<Student> getBadStudents();
	
	public List<Student> findByAverageGreaterThan(float avg);
}
