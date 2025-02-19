package com.employeeapi.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
//
@Entity
@Data
@Table(name = "employee_salary")
public class EmployeeSalary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salary_id")
	private int salaryId;
	
	@Column(name= "salary")
	private double salary;
	
	@ManyToOne(targetEntity = Employee.class)
	@JoinColumn(name = "employee_id",nullable = false)
	private Employee employee;
	
}
