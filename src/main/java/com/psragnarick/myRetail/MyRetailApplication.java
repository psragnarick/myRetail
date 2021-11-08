package com.psragnarick.myRetail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableMongoRepositories("com.psragnarick.myRetail.repositories")
@ComponentScan("com.psragnarick.myRetail.models")
@ComponentScan("com.psragnarick.myRetail.services")
@ComponentScan("com.psragnarick.myRetail.models")
@ComponentScan("com.psragnarick.myRetail.models")
public class MyRetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRetailApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
