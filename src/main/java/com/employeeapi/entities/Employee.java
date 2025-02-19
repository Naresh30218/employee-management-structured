package com.employeeapi.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_mobile")
	private String emloyeeMobile;
	
	@Column(name = "employee_company")
	private String emloyeeCompany;
	
	@Column(name = "employee_designation")
	private String employeeDesignation;

	@Transient
	List<EmployeeFamily> familyList=  new ArrayList<EmployeeFamily>();
}
