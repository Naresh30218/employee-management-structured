package com.employeeapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeapi.entities.Employee;
import com.employeeapi.services.EmployeeServiceImp;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeServiceImp employeeServiceImp;

	@PostMapping()
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		try {
			Employee save = employeeServiceImp.saveEmployee(employee);
			return ResponseEntity.status(HttpStatus.CREATED).body(save);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> displayEmployeeById(@PathVariable("id") int id) {
		try {
			Employee employee = employeeServiceImp.getEmployeeById(id);
			return ResponseEntity.status(HttpStatus.FOUND).body(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping()
	public ResponseEntity<List<Employee>> displayAllEmployees(){
		try {
			List<Employee> employeeList = employeeServiceImp.getAllEmployee();
			return ResponseEntity.status(HttpStatus.FOUND).body(employeeList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id")int id){
		try {
			Employee employee2 = employeeServiceImp.updateEmployee(employee, id);
			return ResponseEntity.status(HttpStatus.CREATED).body(employee2);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> removeEmployee(@PathVariable("id")int id) throws Exception{
		employeeServiceImp.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
	
}
