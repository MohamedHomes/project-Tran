package com.javatpoint.service;

import com.javatpoint.model.orm.Employee;

public interface EmployeeService {
	
	public void deleteById(int theId);

	public Employee getById(int theId);

	public Employee updateEmployee(Employee updatedEmployee);
}
