package com.employeeapi.serviceice;

import java.util.List;

import com.employeeapi.entities.Employee;


public interface EmployeeServiceIce {
	public Employee saveEmployee(Employee employee) ;
	public Employee updateEmployee(Employee employee, int employeeId) throws Exception;
	public Employee getEmployeeById(int employeeId) throws Exception;
	public List<Employee> getAllEmployee();
	public void deleteEmployee(int employeeId) throws Exception;
}
