package com.citas.medicas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class MedicasApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MedicasApplication.class, args);
	}

}
