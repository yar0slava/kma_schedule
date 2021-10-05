package com.example.kma_schedule;

import com.example.schedulerspringbootstarter.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KmaScheduleApplication implements CommandLineRunner {

	@Autowired
	ScheduleService scheduleService;

	public static void main(String[] args) {
		SpringApplication.run(KmaScheduleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		scheduleService.doSmth();
	}
}
