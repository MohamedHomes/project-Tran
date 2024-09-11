package com.javatpoint.service;

import com.javatpoint.model.orm.Employee;

public interface EmployeeService {
 
public Employee save(Employee employee);	
public	List<Employee> findAll();
public	List<Employee> searchEmployees(String keyword);
public void deleteById(int theId);
public Employee getById(int theId);
public Employee updateEmployee(Employee updatedEmployee);

}
