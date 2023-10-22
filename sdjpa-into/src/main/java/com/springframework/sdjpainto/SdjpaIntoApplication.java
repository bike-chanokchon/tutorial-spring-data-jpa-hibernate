package com.springframework.sdjpainto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springframework.sdjpainto.bootstrap"})
public class SdjpaIntoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdjpaIntoApplication.class, args);
	}
}
