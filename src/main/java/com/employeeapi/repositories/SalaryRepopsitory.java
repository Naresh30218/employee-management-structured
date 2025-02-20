package com.employeeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeeapi.entities.Employee;
import com.employeeapi.entities.EmployeeSalary;

@Repository
public interface SalaryRepopsitory extends JpaRepository<EmployeeSalary, Integer>{
	public EmployeeSalary findByEmployee(Employee employee);
	
	@Query("SELECT MAX(es.salary) FROM EmployeeSalary es")
	public double findMaxSalary();
}
