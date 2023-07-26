package com.example.services;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeRepository;
@Service
public class EmployeeService {
	
	@Autowired
	public EmployeRepository employeRepository;
	
	@PostConstruct
	public void initializeEmployeeTable() {
		employeRepository.saveAll(
				Stream.of(
						new Employee("babul", 35000),
						new Employee("abhilash", 20000),
						new Employee("rajaram", 19000),
						new Employee("akhil", 36000)
						).collect(Collectors.toList())
				);
	}
	
	
	public Employee getEmployee(Integer id) {
		return employeRepository.findById(id).orElse(null);
	}
	
	public List<Employee>  getAllEmployee() {
		return  employeRepository.findAll();
	}

}
