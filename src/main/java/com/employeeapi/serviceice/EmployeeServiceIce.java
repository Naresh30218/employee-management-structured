package com.employeeapi.serviceice;


import java.util.List;

import org.springframework.data.domain.Page;

import com.employeeapi.dto.DesignationCountDto;
import com.employeeapi.dto.EmployeeSalaryDto;
import com.employeeapi.entities.Employee;


public interface EmployeeServiceIce {
	public Employee saveEmployee(Employee employee) ;
	public Employee updateEmployee(Employee employee, int employeeId) throws Exception;
	public Employee getEmployeeById(int employeeId) throws Exception;
	public Page<Employee> getAllEmployee(Integer pageNumber, Integer pageSize);
	public void deleteEmployee(int employeeId) throws Exception;
	
	public List<EmployeeSalaryDto> getEmployeeBySalaryRange(double fromSalary, double toSalary) throws Exception;
	public List<EmployeeSalaryDto> getEmployeeOrderBySalary() throws Exception;
	public List<DesignationCountDto> getEmployeeCountByDesignation() throws Exception;
}
