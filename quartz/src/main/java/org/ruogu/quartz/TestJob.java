package org.ruogu.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * TestJob
 * 
 * @author xueyintao 2016年8月15日 下午11:55:36
 */
public class TestJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("job running...");
	}

}
