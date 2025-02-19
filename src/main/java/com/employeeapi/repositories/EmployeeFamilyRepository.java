package com.employeeapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeapi.entities.Employee;
import com.employeeapi.entities.EmployeeFamily;

@Repository
public interface EmployeeFamilyRepository extends JpaRepository<EmployeeFamily, Integer>{
	List<EmployeeFamily> findByEmployee(Employee employee); 
}
