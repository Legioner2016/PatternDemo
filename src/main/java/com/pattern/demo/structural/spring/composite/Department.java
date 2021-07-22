package com.pattern.demo.structural.spring.composite;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

public class Department implements FirmEmployee {
	
	private List<FirmEmployee> employees;
	private Integer id;
	private String name;
	
	@Autowired
	public Department(List<FirmEmployee> employees) {
		this.employees = employees;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void add(FirmEmployee emp) {
		employees.add(emp);
	}

	@Override
	public void remove(FirmEmployee emp) {
		employees.remove(emp);
	}

	@Override
	public List<FirmEmployee> childs() {
		return employees;
	}

	@Override
	public String print() {
		StringBuilder result = new StringBuilder();
		result.append("id: ").append(id).append(", name: ").append(name);
		result.append(", childs: ");
		result.append(employees.stream().map(FirmEmployee::print).collect(Collectors.joining(", ")));
		return result.toString();
	}

}
