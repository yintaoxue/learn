package org.ruogu.quartz;

import java.text.ParseException;

import org.quartz.SchedulerException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws SchedulerException, ParseException, InterruptedException {
		TestJob testJob = new TestJob();
		
		System.out.println("start app...");
		
		String jobName = "job1";
		
//		QuartzManager.addJob(jobName,testJob,"0/5 * * * * ?"); //每5秒钟执行一次
		QuartzManager.addJob(jobName,testJob,"0 0/1 * * * ?"); //每5秒钟执行一次
		
		Thread.sleep(2000000);
		
		System.out.println("end app...");
	}
}
