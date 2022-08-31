package com.emp.spring_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.spring_app.model.Employee;
import com.emp.spring_app.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	// ADD NEW EMPLOYEE
	  @PostMapping("/addEmployee")
	    public Employee addEmployee(@RequestBody Employee employee) {
	        return employeeService.addEmployee(employee);
	    }    
	
	//ADD MORE THAN 1 EMPLOYEE
	  @PostMapping("/addEmployees")
	    public List<Employee> addAllEmployees(@RequestBody List<Employee> employees) {
	        return employeeService.addAllEmployees(employees);
	    }
	
	// GET EMPLOYEE BY ID
	 @GetMapping("/getEmployeeByID/{id}")
	    public Employee getEmployeeById(@PathVariable int id) {
	        return employeeService.getEmployeeById(id);
	    }
	
	//GET EMPLOYEE BY NAME 
    @GetMapping("/getEmployeeByName/{name}")
    public  Employee getEmployeeByName(@PathVariable String name) {
        return  employeeService.getEmployeeByName(name);
    }
    
	
	//UPDATE EMPLOYEE
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);        
    }
	
	//DELETE EMPLOYEE
	  @DeleteMapping("/deleteEmployeeById/{id}")
	    public boolean deleteEmployeeById(@PathVariable int id) {
	        return employeeService.deleteEmployeeById(id);
	    }
}
