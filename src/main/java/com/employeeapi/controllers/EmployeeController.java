package com.employeeapi.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeapi.dto.DesignationCountDto;
import com.employeeapi.dto.EmployeeSalaryDto;
import com.employeeapi.entities.Employee;
import com.employeeapi.services.EmployeeServiceImp;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeServiceImp employeeServiceImp;

//	----------------------add employee handler------------------------------------
	@PostMapping()
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		try {
			Employee save = employeeServiceImp.saveEmployee(employee);
			return ResponseEntity.status(HttpStatus.OK).body(save);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

//	----------------------get employee by id handler------------------------------------
	@GetMapping("/{id}")
	public ResponseEntity<Employee> displayEmployeeById(@PathVariable("id") int id) {
		try {
			Employee employee = employeeServiceImp.getEmployeeById(id);
			return ResponseEntity.status(HttpStatus.OK).body(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

//	----------------------get all employee handler------------------------------------
	@GetMapping()
	public ResponseEntity<Page<Employee>> displayAllEmployees(
			@RequestParam(defaultValue = "0") int pageNumber,
			@RequestParam(defaultValue = "5") int pageSize){
		log.warn(pageNumber + ", " + pageSize);
		try {
			Page<Employee> employeeList = employeeServiceImp.getAllEmployee(pageNumber, pageSize);
			return ResponseEntity.status(HttpStatus.OK).body(employeeList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	

//	----------------------update employee handler------------------------------------
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id")int id){
		try {
			Employee employee2 = employeeServiceImp.updateEmployee(employee, id);
			return ResponseEntity.status(HttpStatus.CREATED).body(employee2);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
//	----------------------delete employee handler------------------------------------
	@DeleteMapping("{id}")
	public ResponseEntity<Void> removeEmployee(@PathVariable("id")int id) throws Exception{
		employeeServiceImp.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
//	----------------------get employee within salary range------------------------------------
	@GetMapping("/bySalaryRange")
	public ResponseEntity<List<EmployeeSalaryDto>> displayEmployeeBySalaryRange(@RequestParam(defaultValue = "0") double fromSalary, @RequestParam(defaultValue = "0") double toSalary){
		try {
			List<EmployeeSalaryDto> employeeList = employeeServiceImp.getEmployeeBySalaryRange(fromSalary, toSalary);
			return ResponseEntity.status(HttpStatus.OK).body(employeeList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
//	----------------------get order by salary------------------------------------
	@GetMapping("/bySalaryOrder")
	public ResponseEntity<List<EmployeeSalaryDto>> displayEmployeeOrderBySalary(){
		try {
			List<EmployeeSalaryDto> employeeList = employeeServiceImp.getEmployeeOrderBySalary();
			return ResponseEntity.status(HttpStatus.OK).body(employeeList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
//	----------------------get employee count by designation------------------------------------
	@GetMapping("/countByDesignation")
	public ResponseEntity<List<DesignationCountDto>> displayEmployeeCountByDesignation(){
		try {
			List<DesignationCountDto> designationCountList = employeeServiceImp.getEmployeeCountByDesignation();
			return ResponseEntity.status(HttpStatus.OK).body(designationCountList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
