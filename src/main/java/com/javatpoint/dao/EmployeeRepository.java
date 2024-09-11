package com.javatpoint.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
	