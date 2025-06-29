package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = { "file:///${CONFIG_LOCATION}/application.properties" })
public class SpringLog4j2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringLog4j2Application.class, args);
	}

}
