package com.employeeapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeapi.entities.EmployeeSalary;
import com.employeeapi.services.EmployeeServiceImp;
import com.employeeapi.services.SalaryServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/salary")
public class SalaryController {
	@Autowired
	private SalaryServiceImpl salaryServiceImpl;
	
	
	
	@PostMapping
	public ResponseEntity<EmployeeSalary> addSalary(@RequestBody EmployeeSalary employeeSalary){
		try {
			EmployeeSalary savedSalary = salaryServiceImpl.saveSalary(employeeSalary);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedSalary);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeSalary> displaySalaryById(@PathVariable("id") int id) {
		try {
			EmployeeSalary salary = salaryServiceImpl.getBySalaryId(id);
			return ResponseEntity.status(HttpStatus.CREATED).body(salary);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeSalary> updateSalary(@PathVariable("id")int id, @RequestBody EmployeeSalary employeeSalary){
		try {
			EmployeeSalary savedSalary = salaryServiceImpl.updateSalary(id,employeeSalary);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedSalary);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<Void> removeSalary(@PathVariable("employeeId")int employeeId){
		try {
			salaryServiceImpl.deleteSalary(employeeId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
