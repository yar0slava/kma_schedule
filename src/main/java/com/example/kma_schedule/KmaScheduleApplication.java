package com.example.kma_schedule;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class KmaScheduleApplication implements ApplicationRunner {
	private static final Logger logger = LogManager.getLogger(KmaScheduleApplication.class);
	private static final Marker marker = MarkerManager.getMarker("ADMIN");

	public static void main(String[] args) {
		SpringApplication.run(KmaScheduleApplication.class, args);

//		ApplicationContext applicationContext = SpringApplication.run(KmaScheduleApplication.class, args);

//		WebSecurityConfigurer webSecurityConfigurer = applicationContext.getBean(WebSecurityConfigurer.class);
//		String[] adminEnd = webSecurityConfigurer.getAdminEndpoints();
//		for (String s: adminEnd) {
//			System.out.println(s);
//		}
//		System.out.println("===========");
//		String[] unsecured = webSecurityConfigurer.getUnsecuredEndpoints();
//		for (String s: unsecured) {
//			System.out.println(s);
//		}
	}

	@Override
	public void run(ApplicationArguments applicationArguments) {
		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("Hey, This is a warning!");
		logger.error("Oops! We have an Error. OK");
		logger.fatal("Damn! Fatal error. Please fix me.");

		logger.info(marker, "ADMIN info");
		logger.error(marker, "ADMIN Error");
	}

}
