package com.winters.be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BeWinterscomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeWinterscomeApplication.class, args);
	}

}
