package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.structural.core.composite.Department;
import com.pattern.demo.structural.core.composite.Employee;

@SpringBootTest
public class CompositeTest {

	@Autowired
	com.pattern.demo.structural.spring.composite.Department  department;

	@Autowired
	List<com.pattern.demo.structural.spring.composite.Employee> employees;

	@Autowired
	List<com.pattern.demo.structural.spring.composite.FirmEmployee> employeesTest;
	
	@Test
	public void testPattern() {
		Department it = new Department(1, "IT");
		Department qa = new Department(2, "Quality");
		Employee q1 = new Employee(201, "First");
		Employee q2 = new Employee(202, "Second");
		qa.add(q1);
		qa.add(q2);
		Department d = new Department(3, "Development");
		Employee d1 = new Employee(301, "Third");
		Employee d2 = new Employee(302, "Fourth");
		d.add(d1);
		d.add(d2);
		it.add(qa);
		it.add(d);
		assertEquals("id: 301, name: Third", d1.print());
		assertEquals("id: 2, name: Quality, childs: id: 201, name: First, id: 202, name: Second", qa.print());
		assertEquals("id: 1, name: IT, childs: id: 2, name: Quality, "
				+ "childs: id: 201, name: First, id: 202, name: Second, "
				+ "id: 3, name: Development, childs: id: 301, name: Third, id: 302, name: Fourth", it.print());
	}

	@Test
	public void testPatternSpring() {
		assertEquals("id: 1000, name: Test department, childs: id: 1001, name: Test1, id: 1002, name: Test2", 
							department.print());
		long founded = department.childs().stream().filter(e -> employees.get(0) == e || employees.get(1) == e).count();
		assertEquals(2, founded);
		assertEquals(3, employeesTest.size());
	}

	
}
