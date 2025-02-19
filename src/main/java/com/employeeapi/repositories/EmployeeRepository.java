package com.employeeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeapi.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
