package com.saraya.EmployeeManagementSystem.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saraya.EmployeeManagementSystem.entitie.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long> {


}
