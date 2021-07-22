package com.pattern.demo.structural.spring.facade;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.keyvalue.annotation.KeySpace;

import lombok.Data;

@KeySpace("departments")
@Data
public class Department {
	@Id
	private Integer id;
	
	private String name;

	@Transient
	private List<Employee> employees;
	
}

