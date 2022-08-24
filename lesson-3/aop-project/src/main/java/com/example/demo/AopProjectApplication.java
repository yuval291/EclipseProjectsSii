package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		Test t = context.getBean(Test.class);
		
		for(int i=0 ; i<15 ; i++) {
			try {
				t.foo();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				t.doo();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}	
		
	}

}
