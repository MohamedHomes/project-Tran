package com.code.employees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.code.employees.model.orm.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("SELECT e FROM Employee e WHERE e.firstName LIKE %:keyword% OR e.lastName LIKE %:keyword% OR CONCAT(e.firstName, ' ', e.lastName) LIKE %:keyword% OR e.email LIKE %:keyword%")
	List<Employee> searchEmployees(@Param("keyword") String keyword);
}
	