package com.example.kma_schedule.quartz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
@DisallowConcurrentExecution
public class SimpleJob implements Job {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Job \"{}\" starting @ {}", jobExecutionContext.getJobDetail().getKey().getName(),
                jobExecutionContext.getFireTime());
    }
}
