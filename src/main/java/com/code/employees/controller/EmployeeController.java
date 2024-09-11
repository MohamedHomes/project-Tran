package com.code.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.employees.model.orm.Employee;
import com.code.employees.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(@RequestParam(required = false) String keyword) {
	List<Employee> employees;
	if (keyword != null) {
	    employees = employeeService.searchEmployees(keyword.trim());
	} else {
	    employees = employeeService.findAll();
	}
	return employees;
    }

    @PostMapping("/insert")
    public Employee save(@RequestBody Employee employee) {
	employeeService.save(employee);
	return employee;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
	employeeService.deleteById(id);
	return "Employee with ID " + id + " deleted";
    }

    @PostMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee updatedEmployee) {
	return employeeService.updateEmployee(updatedEmployee);
    }

    @GetMapping("getEmployeeById")
    public Employee getEmployeeById(@RequestParam("employeeId") int employeeId) {

	Employee employee = employeeService.getById(employeeId);

	return employee;

    }

}
