package com.example.employee_department.service;

import java.util.List;

import com.example.employee_department.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee findByEmployeeId(Integer employeeId);

	List<Employee> findByEmployeeName(String employeeName);

	Employee addEmployee(Employee employee);

	Employee updateEmployee(Integer employeeId, Employee employee);

	void deleteEmployee(Integer employeeId);

	List<Employee> getAllEmployeesByDepartmentName(String departmentName);

	Integer numberOfEmployeeInDepartment(String departmentName);

}
