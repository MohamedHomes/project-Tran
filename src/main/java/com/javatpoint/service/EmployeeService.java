package com.javatpoint.service;

import java.util.List;

import com.javatpoint.model.orm.Employee;

public interface EmployeeService {
	Employee save(Employee employee);	
	List<Employee> findAll();
	List<Employee> searchEmployees(String keyword);
}
