package com.emp.spring_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.spring_app.model.Employee;
import com.emp.spring_app.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> addAllEmployees(List<Employee> employees) {
		
		return  employeeRepository.saveAll(employees);
	}

	public Employee getEmployeeById(int id) {
		
		return employeeRepository.findById(id).orElse(null);
	}

	public Employee getEmployeeByName(String name) {
		
		return employeeRepository.findByName(name);
	}

	public Employee updateEmployee(Employee employee) {
		Employee existingEMP= employeeRepository.findById(employee.getId()).orElse(null);
		 System.out.println(employee);
		if(existingEMP == null)
		{
			System.out.println("Emp not found");
			return employeeRepository.save(employee);
		}
		else
		{
			employeeRepository.deleteById(existingEMP.getId());
			employeeRepository.save(employee);
		}
		return employee;
		
	
	}

	  public boolean deleteEmployeeById(int id) {
	        Employee existingEMP = employeeRepository.getById(id);
	        if(existingEMP != null) {
	            employeeRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

	
}
