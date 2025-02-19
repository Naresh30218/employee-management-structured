package com.employeeapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeeapi.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	@Query("SELECT es.employee.employeeName, es.salary FROM EmployeeSalary es JOIN es.employee e WHERE es.salary BETWEEN :fromSalary AND :toSalary")
	public List findEmployeeBySalaryRange(@Param("fromSalary")double fromSalary, @Param("toSalary")double toSalary);
}
