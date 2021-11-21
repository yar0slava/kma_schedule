package com.example.kma_schedule;

//import com.example.schedulerspringbootstarter.WebSecurityConfigurer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class KmaScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(KmaScheduleApplication.class, args);

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

}
