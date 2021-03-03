package com.example.employee_department.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_department.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByEmployeeId(Integer employeeId);

	Employee findByEmployeeName(String employeeName);

	List<Employee> findAllByEmployeeName(String employeeName);

	List<Employee> findAllEmployeeByDepartmentId(int departmentId);

}
