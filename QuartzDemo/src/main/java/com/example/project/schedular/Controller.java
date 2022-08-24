package com.example.project.schedular;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j

@Configuration
public class Controller{
	
	@Autowired
	private Scheduler scheduler;
	
	@Bean
	private JobDetail buildJobDetail() {
		 return JobBuilder.newJob(SystemJob.class)
				 .withIdentity("systemjob", "job-group")
				 .build();
	}
	@Bean
	private Trigger buildTrigger(JobDetail job) {
		 return  TriggerBuilder.newTrigger()
				 .forJob(job)
				 .withIdentity("simpleTrigger", "trigger-group")
	             .withSchedule(SimpleScheduleBuilder.repeatMinutelyForever())
	             .build();
	}
	@Bean
	public static Scheduler scheduler(Trigger trigger, JobDetail job)
			  throws SchedulerException {
		        Scheduler scheduler = new StdSchedulerFactory().getScheduler(); 
		        scheduler.start(); 
		        scheduler.scheduleJob(job, trigger);
			    return scheduler;
			}
	
}