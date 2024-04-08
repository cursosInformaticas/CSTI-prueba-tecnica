package com.springcloud.msvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Msvc01Application {

	public static void main(String[] args) {
		SpringApplication.run(Msvc01Application.class, args);
	}

}
