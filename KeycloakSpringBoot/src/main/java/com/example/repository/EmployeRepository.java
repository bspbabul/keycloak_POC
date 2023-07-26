package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Employee;

public interface EmployeRepository extends JpaRepository<Employee, Integer> {

}
