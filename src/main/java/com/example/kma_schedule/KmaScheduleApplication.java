package com.example.kma_schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableJpaRepositories
public class KmaScheduleApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(KmaScheduleApplication.class);
		application.setAdditionalProfiles("dev");
		application.run(args);
	}

}
