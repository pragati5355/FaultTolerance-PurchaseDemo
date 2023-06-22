package com.purchasedemo.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping()	
public class PurchaseController {
		
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/home")
	public String home() {
		return "This is a Home page of Hystrix Server";
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	@GetMapping("/purchase")
	@HystrixCommand(fallbackMethod = "handleCartPurchase")
	public Map<String, String> cartPurchase(){
		
		Map<String, String>  value= new HashMap<>();
		
		String purchase = "This is a cart purchase response.";
		
		String product = restTemplate.getForObject("http://localhost:8082/product/1", String.class);
			
		value.put("purchase", purchase);
		value.put("Product", product);
		return value;
	}

	
	public Map<String, String>  handleCartPurchase()  {
	
		Map<String, String>  value= new HashMap<>();
		String purchase = "FallBack : This is a cart purchase response.";
		value.put("purchase", purchase);
		return value;
	}
	

}
