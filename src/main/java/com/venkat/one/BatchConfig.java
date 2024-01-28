package com.venkat.one;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private PlatformTransactionManager ptm;
	
	@Autowired
	private JobNotificationListener jobListener;

	@Bean
	public Job job() {
		return new JobBuilder("first-demo-batch", jobRepository)
				.listener(jobListener)
				.flow(step())
				.end()
				.build();
	}

	@Bean
	public Step step() {
		return new StepBuilder("step-one", jobRepository)
				.<String, String>chunk(2, ptm)
				.reader(new Reader())
				.processor(new Processor())
				.writer(new Writer())
				.taskExecutor(taskExecutor())
				.build();
	}
	
	@Bean
	public TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
		taskExecutor.setConcurrencyLimit(10);
		return taskExecutor;
	}

}
