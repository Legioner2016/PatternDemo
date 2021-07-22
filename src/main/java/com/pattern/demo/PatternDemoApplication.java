package com.pattern.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@SpringBootApplication
@EnableMapRepositories
@EnableAspectJAutoProxy
public class PatternDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatternDemoApplication.class, args);
	}

}
