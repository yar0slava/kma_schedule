package com.example.kma_schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class KmaScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(KmaScheduleApplication.class, args);
	}

}
