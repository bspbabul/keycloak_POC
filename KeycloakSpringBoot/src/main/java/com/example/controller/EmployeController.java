package com.example.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeController {

	@Autowired
	public EmployeeService employeeService;
	
	
	@GetMapping("/{id}")
	@RolesAllowed("client_user")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id){
		
		return ResponseEntity.ok(employeeService.getEmployee(id));
		
	}
	
	@GetMapping
	@RolesAllowed("client_admin")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		return ResponseEntity.ok(employeeService.getAllEmployee());
		
	}
 }

