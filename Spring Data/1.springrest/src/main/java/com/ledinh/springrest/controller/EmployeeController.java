package com.ledinh.springrest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ledinh.springrest.exception.EmployeeNotFoundException;
import com.ledinh.springrest.model.Employee;
import com.ledinh.springrest.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	private final EmployeeRepository employeeRepository;
	
	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	
	@PostMapping("/employees")
	public Employee newEmployee(@RequestBody Employee newEmployee) {
		return employeeRepository.save(newEmployee);
	}
	
	@GetMapping("/employees/{id}")
	public Employee sigleEp(@PathVariable Long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	}
	
	
	@PutMapping("/employees/{id}")
	public Employee replEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		return employeeRepository.findById(id)
				.map(employee -> {
					employee.setName(newEmployee.getName());
					employee.setRole(employee.getRole());
					return employeeRepository.save(employee);
				}).orElseGet(() -> {
					newEmployee.setId(id);
					return employeeRepository.save(newEmployee);
				});
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeRepository.deleteById(id);
	}
	
	
	
	
	
	
	
}
