package com.example.kma_schedule.quartz;

import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzSubmitJobs {
    private static final String CRON_PATTERN = "0/15 * * ? * * *"; // every 15 seconds

    @Bean(name = "simpleTask")
    public JobDetailFactoryBean simpleTask() {
        return QuartzConfig.createJobDetail(SimpleJob.class, "Simple Quartz Job");
    }

    @Bean(name = "simpleTrigger")
    public SimpleTriggerFactoryBean simpleTrigger(@Qualifier("simpleTask") JobDetail jobDetail) {
        return QuartzConfig.createTrigger(jobDetail, 6000, "Simple Quartz Job Trigger");
    }

    @Bean(name = "cronJob")
    public JobDetailFactoryBean cronJob() {
        return QuartzConfig.createJobDetail(SimpleJob.class, "Cron Quartz Job");
    }

    @Bean(name = "cronTrigger")
    public CronTriggerFactoryBean cronTrigger(@Qualifier("cronJob") JobDetail jobDetail) {
        return QuartzConfig.createCronTrigger(jobDetail, CRON_PATTERN, "Cron Quartz Job Trigger");
    }
}
