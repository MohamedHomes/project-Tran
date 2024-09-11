package com.code.employees.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.employees.model.orm.Employee;
import com.code.employees.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> searchEmployees(String keyword) {
		
		return employeeRepository.searchEmployees(keyword);
	}
	public void deleteById(int id) {
		employeeRepository.deleteById(id);	
	}


	@Override
	public Employee getById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Did not find employee id - " + id);
		}
		return theEmployee;
	}

	
	@Override
    public Employee updateEmployee(Employee updatedEmployee) {
        Employee existingEmployee = getById(updatedEmployee.getId());

        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setEmail(updatedEmployee.getEmail());

        return employeeRepository.save(existingEmployee);
    }
}
