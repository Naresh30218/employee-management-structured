package com.employeeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmployeeSalaryDto {
	private int emloyeeId;
	private String employeeName;
	private double salary;
	
}
