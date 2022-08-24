package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	ClassRepository classRepo;
	
	public void addNewStudent(Student student,Class c) {
		classRepo.save(c);
		
		student.setClass_id(c);
		studentRepo.save(student);
	}
	
	public List<Student> getAllStudent(){
		List<Student> allStudent = studentRepo.findAll();
		return allStudent;
	}
	
	public List<Class> getAllClass(){
		List<Class> allClass = classRepo.findAll();
		return allClass;
	}
	
	public List<Student> getAllStudentInClass(Class c){
		List<Student> allStudentInClass = studentRepo.findByClassId(c);
		return allStudentInClass;
	}
	
	public List<Student> getAllStudentAverage(int avg){
		List<Student> allStudentAvg=null;
		
		if(avg>=85) {
			allStudentAvg = studentRepo.getExcelentStudents();
//			allStudentAvg = studentRepo.findByAverageGreaterThan(avg);
		}else if(avg<=60) {
			allStudentAvg = studentRepo.getBadStudents();
		}
		
		return allStudentAvg;
	}	

}
