package com.example.demo;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuartzDemoApplication {

	public static void main(String[] args) {
		try {
			// define the job and tie it to our HelloJob class
			JobDetail job1 = JobBuilder.newJob(HelloJob.class).withIdentity("helloJob", "group1").build();
			
            Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "group1")
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(30)).build();
            
            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler(); 
            scheduler1.start(); 
            scheduler1.scheduleJob(job1, trigger1);
            
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
