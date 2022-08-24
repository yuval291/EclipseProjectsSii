package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class RestrictionsOnEntriesApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		Test t = context.getBean(Test.class);
		Thread t1 = new Thread() ;
		Thread t2 = new Thread();
		Thread t3 = new Thread();
		
		t1.start();
		t2.start();
		t.foo();
		t.foo();
		
		t.foo();
	}
	
	 public void run() {
		   
		  }

}
