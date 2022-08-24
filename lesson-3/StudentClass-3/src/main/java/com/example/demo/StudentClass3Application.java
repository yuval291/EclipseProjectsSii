package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentClass3Application implements CommandLineRunner {
	
	@Autowired
	StudentService service;

	public static void main(String[] args) {
		SpringApplication.run(StudentClass3Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Class c1 = new Class(1,"a");
		Class c2 = new Class(2,"b");
		Class c3 = new Class(3,"c");
		Class c4 = new Class(4,"d");
		
		
		Student s1 = new Student("333","yuval",86);
		service.addNewStudent(s1,c1);
		Student s2 = new Student("458","dekel",98);
		service.addNewStudent(s2,c2);
		Student s3 = new Student("123","ariel",55);
		service.addNewStudent(s3,c1);
		Student s4 = new Student("225","daniel",25);
		service.addNewStudent(s4,c4);
		Student s5 = new Student("895","yoav",70);
		service.addNewStudent(s5,c3);
		Student s6 = new Student("885","or",100);
		service.addNewStudent(s6,c3);
		
		
		System.out.println("All Student: ");
		for (Student student : service.getAllStudent()) {
			System.out.println(student.toString());
		}
	
		System.out.println(" ");
		
		System.out.println("All Classes: ");
		for (Class c : service.getAllClass()) {
			System.out.println(c.toString());
		}
		
		System.out.println(" ");
		
		System.out.println("List of students who are enrolled in the class 1 : ");
		System.out.println(service.getAllStudentInClass(c1));
		
		System.out.println(" ");
		
		System.out.println("List of students who are enrolled in the class 2 : ");
		System.out.println(service.getAllStudentInClass(c2));
		
		System.out.println(" ");
		
		System.out.println("List of students who are enrolled in the class 3 : ");
		System.out.println(service.getAllStudentInClass(c3));
		
		System.out.println(" ");
		
		System.out.println("List of students who are enrolled in the class 4 : ");
		System.out.println(service.getAllStudentInClass(c4));
		
		System.out.println(" ");
		
		System.out.println("List of students whose average is above 85: ");
		System.out.println(service.getAllStudentAverage(85));
		
		System.out.println("List of students whose average is less than 60: ");
		System.out.println(service.getAllStudentAverage(60));
	}

}
