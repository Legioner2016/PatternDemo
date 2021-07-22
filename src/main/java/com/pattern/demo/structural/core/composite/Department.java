package com.pattern.demo.structural.core.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Department implements FirmEmployee {
	
	private List<FirmEmployee> employees = new ArrayList<>();
	final private Integer id;
	final private String name;

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
