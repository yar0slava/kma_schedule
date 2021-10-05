package com.example.kma_schedule;

import com.example.kma_schedule.database.entity.Record;
import com.example.kma_schedule.database.repository.RecordRepository;
import com.example.schedulerspringbootstarter.ScheduleService;
import com.example.schedulerspringbootstarter.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class KmaScheduleApplication {


	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(KmaScheduleApplication.class, args);

		ScheduleServiceImpl scheduleService = applicationContext.getBean(ScheduleServiceImpl.class);
		scheduleService.doSmth();
	}


}
