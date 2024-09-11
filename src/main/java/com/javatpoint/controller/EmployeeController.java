package com.javatpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.orm.Employee;
import com.javatpoint.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@DeleteMapping("/delete/{employeeId}")
    public String delete(@PathVariable("employeeId") int id) {
        employeeService.deleteById(id);
        return "Employee with ID " + id + " deleted";
    }
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee updatedEmployee) {
	    return employeeService.updateEmployee(updatedEmployee);
	}
	
	@GetMapping("get/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId) {
		
        Employee employee = employeeService.getById(employeeId);
        
        return employee;
        
    }
	
	


}
