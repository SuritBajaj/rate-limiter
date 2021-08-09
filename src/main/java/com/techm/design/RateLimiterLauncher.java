package com.techm.design;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RateLimiterLauncher {
	
	/**
	 * Launcher class to initialize and load the servlet in web container.
	 * @param args
	 */
	public static void main(String[] args) {
		// Launches our spring rate limiting app.
		SpringApplication.run(RateLimiterLauncher.class, args);
	}

}
