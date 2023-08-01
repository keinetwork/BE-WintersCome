package com.winters.be;

import com.winters.be.config.FullBeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(nameGenerator = FullBeanNameGenerator.class)
public class BeWinterscomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeWinterscomeApplication.class, args);
	}

}
