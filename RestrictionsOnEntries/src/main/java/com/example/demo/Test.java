package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Test {

	@MyAnnotation
	public void foo() {
		System.out.println("Goes into function");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
