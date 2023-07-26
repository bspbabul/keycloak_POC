package com.example.demo.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Controller
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	public EmployeeRepository employeeRepository;

	@PostMapping("/admin")

	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeRepository.save(employee));
	}

	@GetMapping("/user")

	public ResponseEntity<List<Employee>> getEmployee() {
		return ResponseEntity.ok(employeeRepository.findAll());
	}

}
