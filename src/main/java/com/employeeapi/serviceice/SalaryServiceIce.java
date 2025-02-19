package com.employeeapi.serviceice;

import com.employeeapi.entities.EmployeeSalary;

public interface SalaryServiceIce {
	public EmployeeSalary saveSalary(EmployeeSalary employeeSalary) throws Exception; 
	public EmployeeSalary getBySalaryId(int id) throws Exception;
	public EmployeeSalary updateSalary(int id, EmployeeSalary employeeSalary) throws Exception; 
	public void deleteSalary(int id) throws Exception; 
}
