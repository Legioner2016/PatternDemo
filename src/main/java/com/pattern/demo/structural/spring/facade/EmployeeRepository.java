package com.pattern.demo.structural.spring.facade;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	List<Employee> findAllByDepartmentId(Integer id);
	
}
