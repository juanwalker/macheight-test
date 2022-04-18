package com.maceight;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MacEightApplication {
	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(MacEightApplication.class, args);
	}
}
