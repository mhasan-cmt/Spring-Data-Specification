package com.devmahmud.springdataspecificationdemo;

import com.devmahmud.springdataspecificationdemo.service.InitDbService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataSpecificationDemoApplication implements CommandLineRunner {
	private final InitDbService initDbService;

	public SpringDataSpecificationDemoApplication(InitDbService initDbService) {
		this.initDbService = initDbService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataSpecificationDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initDbService.init();
	}
}
