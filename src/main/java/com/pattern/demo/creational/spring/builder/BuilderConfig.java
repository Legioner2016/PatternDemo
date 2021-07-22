package com.pattern.demo.creational.spring.builder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.pattern.demo.creational.core.builder.WithBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Configuration
public class BuilderConfig {

	@AllArgsConstructor @Getter
	private static class Info {
		private final Integer id;
		private final String name;
	}
	
	@Bean
	Info info() {
		return new Info(1, "test");
	}
	
	@Bean
	@DependsOn("info")
	WithBuilder withBuilder(Info info) {
		return WithBuilder.builder().name(info.getName()).id(info.getId()).build(); 
	}
	
	
}
