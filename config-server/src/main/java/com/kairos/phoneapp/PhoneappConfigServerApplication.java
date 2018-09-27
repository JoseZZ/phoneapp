package com.kairos.phoneapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class PhoneappConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneappConfigServerApplication.class, args);
	}
}
