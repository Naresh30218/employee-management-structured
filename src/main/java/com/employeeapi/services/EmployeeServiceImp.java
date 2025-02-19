package com.employeeapi.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapi.entities.Employee;
import com.employeeapi.entities.EmployeeFamily;
import com.employeeapi.exceptionHandler.ResourceNotFoundException;
import com.employeeapi.repositories.EmployeeFamilyRepository;
import com.employeeapi.repositories.EmployeeRepository;
import com.employeeapi.serviceice.EmployeeServiceIce;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImp implements EmployeeServiceIce{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeFamilyRepository employeeFamilyRepository;
	
	//--------------------------save employee service-----------------------------
	@Override
	public Employee saveEmployee(Employee employee) {
		Employee save = null;
		try {
			save = employeeRepository.save(employee);
			
			for (EmployeeFamily family : employee.getFamilyList()) {
				family.setEmployee(save);
				employeeFamilyRepository.save(family);
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return save;
	}


	//--------------------------get employee by Id-----------------------------
	@Override
	public Employee getEmployeeById(int employeeId) throws Exception {
		Employee employee = employeeRepository.findById(employeeId).get(); 
		if (employee==null) {
			throw new Exception(new ResourceNotFoundException("this employee is not available"));
		}
		employee.setFamilyList(employeeFamilyRepository.findByEmployee(employee));
		return employee;
	}

	//--------------------------get all employee--------------------------------
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employeeList = employeeRepository.findAll();
		for (Employee employee : employeeList) {
			employee.setFamilyList(employeeFamilyRepository.findByEmployee(employee));
		}
		return employeeList;
	}
	
	//--------------------------update employee service-----------------------------
	@Override
	public Employee updateEmployee(Employee employee, int employeeId) throws Exception {
		Employee employee2 = getEmployeeById(employeeId); 
		if (employee==null) {
			throw new Exception(new ResourceNotFoundException("this employee is not available"));
		}
		employee2.setEmployeeName(employee.getEmployeeName());
		employee2.setEmloyeeCompany(employee.getEmloyeeCompany());
		employee2.setEmployeeDesignation(employee.getEmployeeDesignation());
		
		Employee save = employeeRepository.save(employee2);
		
		for (EmployeeFamily family : employee.getFamilyList()) {
			EmployeeFamily employeeFamily = employeeFamilyRepository.findById(family.getFamilyId()).orElseThrow();
			
			employeeFamily.setFamilyName(family.getFamilyName());
			employeeFamily.setFamilyMobile(family.getFamilyMobile());
			employeeFamily.setEmployee(save);
			
			employeeFamilyRepository.save(employeeFamily);
		}
		
		return save;
	}

	//--------------------------delete employee by ID--------------------------------
	@Override
	public void deleteEmployee(int employeeId) throws Exception {
		Employee employee = getEmployeeById(employeeId); 
		if (employee==null) {
			throw new Exception(new ResourceNotFoundException("this employee is not available"));
		}
		List<EmployeeFamily> familyList = employeeFamilyRepository.findByEmployee(employee);
		for (EmployeeFamily employeeFamily : familyList) {
			employeeFamilyRepository.delete(employeeFamily);
		}
		employeeRepository.deleteById(employeeId);
	}


	@Override
	public List getEmployeeBySalaryRange(double fromSalary, double toSalary) throws Exception {
		List employeeList = employeeRepository.findEmployeeBySalaryRange(fromSalary, toSalary);
		if (employeeList.isEmpty()) {
			throw new Exception(new ResourceNotFoundException("this employee is not available"));
		}
		return employeeList;
	}

}
