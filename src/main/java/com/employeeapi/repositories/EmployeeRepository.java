package com.employeeapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeeapi.dto.DesignationCountDto;
import com.employeeapi.dto.EmployeeSalaryDto;
import com.employeeapi.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	@Query("SELECT new com.employeeapi.dto.EmployeeSalaryDto(e.employeeId,e.employeeName,es.salary)"
			+ "FROM EmployeeSalary es JOIN es.employee e "
			+ "WHERE es.salary BETWEEN :fromSalary AND :toSalary")
	public List<EmployeeSalaryDto> findEmployeeBySalaryRange(@Param("fromSalary")double fromSalary, @Param("toSalary")double toSalary);
	
	@Query("SELECT new com.employeeapi.dto.EmployeeSalaryDto(e.employeeId,e.employeeName,es.salary)"
			+ "FROM EmployeeSalary es JOIN es.employee e "
			+ "ORDER BY es.salary")
	public List<EmployeeSalaryDto> findEmployeeOrderBySalary();
	
	@Query("SELECT new com.employeeapi.dto.DesignationCountDto(e.employeeDesignation,COUNT(e))"+
			"FROM Employee e GROUP BY e.employeeDesignation")
	public List<DesignationCountDto> findDesigntionEmlpoyeeCount();
}
