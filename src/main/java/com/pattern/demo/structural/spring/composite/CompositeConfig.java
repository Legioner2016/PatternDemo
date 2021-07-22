package com.pattern.demo.structural.spring.composite;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompositeConfig {
	
	@Bean
	public Employee  firstEmploye() {
		return new Employee(1001, "Test1");
	}

	@Bean
	public Employee  secondEmploye() {
		return new Employee(1002, "Test2");
	}
	
	@Bean
	public Department department(List<Employee> employees) {
		Department dep = new Department(employees.stream().map(e -> (FirmEmployee)e).collect(Collectors.toList()));
		dep.setId(1000);
		dep.setName("Test department");
		return dep;
	}

	
}
