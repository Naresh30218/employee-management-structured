package com.employeeapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapi.entities.Employee;
import com.employeeapi.entities.EmployeeSalary;
import com.employeeapi.exceptionHandler.ResourceNotFoundException;
import com.employeeapi.repositories.EmployeeRepository;
import com.employeeapi.repositories.SalaryRepopsitory;
import com.employeeapi.serviceice.SalaryServiceIce;

@Service
public class SalaryServiceImpl implements SalaryServiceIce{
	@Autowired
	private SalaryRepopsitory salaryRepopsitory;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
//	----------------save salary service----------------------------
	@Override
	public EmployeeSalary saveSalary(EmployeeSalary employeeSalary) throws Exception {
		Employee employee = employeeRepository.findById(employeeSalary.getEmployee().getEmployeeId()).orElseThrow(()->new ResourceNotFoundException("employee not found"));
		employeeSalary.setEmployee(employee);
		return salaryRepopsitory.save(employeeSalary);
	}

//	----------------update salary service----------------------------
	@Override
	public EmployeeSalary updateSalary(int id, EmployeeSalary employeeSalary) throws Exception{
		EmployeeSalary exiEmployeeSalary = getBySalaryId(id);
		Employee employee = employeeRepository.findById(employeeSalary.getEmployee().getEmployeeId()).orElseThrow(()->new ResourceNotFoundException("salary not found"));
		exiEmployeeSalary.setEmployee(employee);
		exiEmployeeSalary.setSalary(employeeSalary.getSalary());
		salaryRepopsitory.save(exiEmployeeSalary);
		return exiEmployeeSalary;
	}

//	----------------delete salary service----------------------------
	@Override
	public void deleteSalary(int id) throws Exception{
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee not found"));
		
		EmployeeSalary employeeSalary = salaryRepopsitory.findByEmployee(employee);
		int salaryId = employeeSalary.getSalaryId();
		
		salaryRepopsitory.deleteById(salaryId);
		
	}

//	----------------get salary By id service----------------------------
	@Override
	public EmployeeSalary getBySalaryId(int id) throws Exception {
		EmployeeSalary salary = salaryRepopsitory.findById(id).orElseThrow(()->new ResourceNotFoundException("salary not found"));
		return salary;
	}

}
