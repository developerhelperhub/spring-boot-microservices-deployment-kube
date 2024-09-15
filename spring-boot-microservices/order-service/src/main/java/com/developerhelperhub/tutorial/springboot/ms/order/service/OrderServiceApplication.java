package com.developerhelperhub.tutorial.springboot.ms.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class OrderServiceApplication implements ApplicationRunner {

	@Autowired
	private StartupHealthIndicator startupProbeHealthIndicator;

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Application loading information.....");

		// We can add logic to load initial code after application start successfully.
		// Startup health endpoint help Kubernetes avoid to kill the application if the application loading process is taking longer

		Thread.sleep(20000);

		this.startupProbeHealthIndicator.setStartupComplete(true);

		log.info("Application loading successfully!");
	}
}
