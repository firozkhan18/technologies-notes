package com.springboot.microservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.microservice.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByAgeGreaterThan(int age);
}
