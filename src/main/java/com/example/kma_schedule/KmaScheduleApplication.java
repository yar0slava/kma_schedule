package com.example.kma_schedule;

import com.example.schedulerspringbootstarter.ScheduleServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class KmaScheduleApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(KmaScheduleApplication.class, args);

		ScheduleServiceImpl scheduleService = applicationContext.getBean(ScheduleServiceImpl.class);
		scheduleService.doSmth();
	}

}
