package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column
	private String student_id;
	@Column
	private String fullName;
	@Column
	private int average;
	
	@ManyToOne(/*cascade= CascadeType.ALL, fetch = FetchType.EAGER*/)
	@JoinColumn(name="classId")
	private Class classId;
	
	public Student(String student_id, String fullName, int average, Class class_id) {
		super();
		this.student_id = student_id;
		this.fullName = fullName;
		this.average = average;
		this.classId = class_id;
	}
	
	public Student(String student_id, String fullName, int average) {
		super();
		this.student_id = student_id;
		this.fullName = fullName;
		this.average = average;
	}


	public Student() {
		super();
	}
	
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", fullName=" + fullName + ", average=" + average + ", class_id="
				+ classId.getClassName() + "]";
	}

	public String getStudent_id() {
		return student_id;
	}


	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public int getAverage() {
		return average;
	}


	public void setAverage(int average) {
		this.average = average;
	}


	public Class getClass_id() {
		return classId;
	}


	public void setClass_id(Class class_id) {
		this.classId = class_id;
	}

	

}
