package com.challenge.wenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WenanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WenanceApplication.class, args);
	}

}
