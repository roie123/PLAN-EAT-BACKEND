package com.RoieIvri.MyFamilysMealPlanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MyFamilysMealPlannerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyFamilysMealPlannerApplication.class, args);


	}

}
