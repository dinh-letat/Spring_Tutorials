package com.ledinh.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ledinh.springrest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
