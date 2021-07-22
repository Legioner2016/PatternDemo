package com.pattern.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pattern.demo.structural.core.facade.ShapeMaker;
import com.pattern.demo.structural.spring.facade.Department;
import com.pattern.demo.structural.spring.facade.DepartmentRepository;
import com.pattern.demo.structural.spring.facade.DepartmentService;
import com.pattern.demo.structural.spring.facade.Employee;
import com.pattern.demo.structural.spring.facade.EmployeeRepository;

/**
 * I think that facade pattern breach the S and I principle of SOLID.
 * But it is often used in spring abstraction levels.
 * 
 * @author legioner
 *
 */
@SpringBootTest
public class FacadeTest {

	@Autowired
	DepartmentRepository dRepository;
	
	@Autowired
	EmployeeRepository 	eRepository;
	
	@Autowired
	DepartmentService	service;
	
	@Test
	public void testPattern() {
		ShapeMaker sm = new ShapeMaker();
		assertEquals("circle", sm.drawCircle());
		assertEquals("rectangle", sm.drawRectangle());
	}

	@Test
	public void testPatternSpring() {
		Department dep = new Department();
		dep.setName("Test");
		Integer id = dRepository.save(dep).getId();
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("First");
		emp.setDepartmentId(id);
		eRepository.save(emp);
		//here is facade (service) - several calls to different dao combined to one client method
		Department loaded = service.getDepartmentById(id);
		assertEquals(1, loaded.getEmployees().size());
		assertEquals("First", loaded.getEmployees().get(0).getName());
	}

	
}
