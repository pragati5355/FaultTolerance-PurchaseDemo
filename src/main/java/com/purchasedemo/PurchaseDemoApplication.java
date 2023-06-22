package com.purchasedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
	
@SpringBootApplication
@EnableCircuitBreaker
public class PurchaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseDemoApplication.class, args);
	}

}
