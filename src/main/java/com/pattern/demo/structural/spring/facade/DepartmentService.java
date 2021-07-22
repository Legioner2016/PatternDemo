package com.pattern.demo.structural.spring.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository	dRepository;
	
	@Autowired
	EmployeeRepository		eRepository;
	
	public Department getDepartmentById(Integer id) {
		Department dep = dRepository.findById(id).get();
		dep.setEmployees(eRepository.findAllByDepartmentId(id));
		return dep;
	}

}
