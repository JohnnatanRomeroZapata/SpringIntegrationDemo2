package com.example.SpringIntegrationDemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.annotation.IntegrationComponentScan;

@SpringBootApplication
@IntegrationComponentScan
public class SpringIntegrationDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationDemo2Application.class, args);
	}
	
}
