package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestService {

	@GetMapping(path = "/hello")
	public String helloWorld() {
		log.info("-----------HELLO WORLD------------");
		return "Hello World";
	}
}
