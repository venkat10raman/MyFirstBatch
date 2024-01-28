package com.venkat.one;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobNotificationListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Job Started");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("Job Finished");
	}

	
	
}
