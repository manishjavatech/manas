package com.manas;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppLauncher {
	public static void main(String[] args) {
		ApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext(
					"spring/batch/jobs/job-employee.xml");
			JobLauncher jobLauncher = (JobLauncher) context
					.getBean("jobLauncher");
			Job job = (Job) context.getBean("employeeJob");
			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			((AbstractApplicationContext) context).close();
		}
	}
}
