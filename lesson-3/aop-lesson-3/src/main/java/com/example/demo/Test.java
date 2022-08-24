package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Test implements Runnable{

	@Lock
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println("Done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	

}
