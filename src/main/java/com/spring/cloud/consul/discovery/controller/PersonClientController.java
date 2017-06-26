package com.spring.cloud.consul.discovery.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController("/personsClient")
public class PersonClientController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(PersonClientController.class);

	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/client")
	public String fetchPersonsDetails() {
		Optional<ServiceInstance> personsInstance = discoveryClient.getInstances("springCloudClient").stream()
				.findFirst();
		ServiceInstance serviceInstance = personsInstance.get();
		String url = serviceInstance.getUri().toString() + "/springCloudClient/personId/persons";
		System.out.println(url);
		LOGGER.info("URL : "+url);

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("personId", "personId");
		String response = (String) restTemplate.getForObject(url, String.class);
		System.out.println(response);
		LOGGER.info("response : "+response);
		return "String";
	}
}
