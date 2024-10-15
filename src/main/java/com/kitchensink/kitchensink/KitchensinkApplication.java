package com.kitchensink.kitchensink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KitchensinkApplication {

	public static void main(String[] args) {

		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Error loading H2 driver: " + e.getMessage());
			e.printStackTrace();
		}
		SpringApplication.run(KitchensinkApplication.class, args);


	}

}
