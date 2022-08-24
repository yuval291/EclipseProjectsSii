package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Test {

	@Entries(entries = 10)
	public void foo() {
		System.out.println(" foo ");	
	}
	
	@Entries(entries = 5)
	public void doo() {
		System.out.println(" doo ");	
	}

	
}
