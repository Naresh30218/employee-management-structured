package com.employeeapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_family")
public class EmployeeFamily {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "family_id")
	private int familyId;
	
	@Column(name = "family_name")
	private String familyName;
	
	@Column(name = "family_mobile")
	private String familyMobile;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	@JsonBackReference
	private Employee employee;
}
