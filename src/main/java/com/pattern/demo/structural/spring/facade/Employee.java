package com.pattern.demo.structural.spring.facade;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import lombok.Data;

@KeySpace("employees")
@Data
public class Employee {
	@Id
	private Integer id;
	
	private String name;
	
	private Integer departmentId;

}
