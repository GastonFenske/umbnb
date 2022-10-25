package com.um;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UmbnbApplication {

	public static void main(String[] args) {
		new FirebaseAppInitialization();
		SpringApplication.run(UmbnbApplication.class, args);
	}
}
