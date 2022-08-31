package com.emp.spring_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.spring_app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee getByName(String name);

	Employee findByName(String name);

}
