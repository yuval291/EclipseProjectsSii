package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBasicSecurityApplication {

	public static void main(String[] args) {
		
		RobotBuilder oldStyleRobot = new OldRobotBuilder();
		
		RobotEngineer robotEngineer =  new RobotEngineer(oldStyleRobot);
		
		robotEngineer.makeRobot();
		
		Robot firstRobot = robotEngineer.getRobot();
		
		System.out.println("Robot");
		
		System.out.println("Robot Head Type: "+firstRobot.getRobotHead());
		
		System.out.println("Robot Arms Type: "+firstRobot.getRobotArms());
		
		System.out.println("Robot Legs Type: "+firstRobot.getRobotLegs());
		
		System.out.println("Robot Torso Type: "+firstRobot.getRobotTorso());
			
	}

}
