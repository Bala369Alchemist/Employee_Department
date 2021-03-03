package com.example.employee_department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_department.entity.Employee;
import com.example.employee_department.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	// get all employee (works fine)
	@GetMapping(value = "/getAllEmployees")
	List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	// to get employee by id (works fine)
	@GetMapping(value = "/getEmployee/{employeeId}")
	Employee findByEmployeeId(@PathVariable Integer employeeId) {
		return employeeService.findByEmployeeId(employeeId);
	}

	// to get employee by employee name (works fine)
	@GetMapping(value = "/getEmployeeByName/{employeeName}")
	List<Employee> findByEmployeeName(@PathVariable String employeeName) {
		return employeeService.findByEmployeeName(employeeName);
	}

	// to get employee by department name
	@GetMapping(value = "/getEmployeesByDepartmentName/{departmentName}")
	List<Employee> getAllEmployeesByDepartmentName(@PathVariable String departmentName){
		return employeeService.getAllEmployeesByDepartmentName(departmentName);
	}
	
	// to get number of employees in department
	@GetMapping(value="/numberOfEmployeeInDepartment/{departmentName}")
	Integer numberOfEmployeeInDepartment(@PathVariable String departmentName) {
		return employeeService.numberOfEmployeeInDepartment(departmentName);
	}
	
	// add employee (works fine)
	@PostMapping(value = "/addEmployee")
	Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	// update employee (works fine)
	@PutMapping(value = "/updateEmployee/{employeeId}")
	Employee updateDepartment(@PathVariable Integer employeeId, @RequestBody Employee employee) {
		return employeeService.updateEmployee(employeeId, employee);
	}

	// delete employee by id (works fine)
	@DeleteMapping(value = "/deleteEmployee/{employeeId}")
	void deleteEmployee(@PathVariable Integer employeeId) {
		employeeService.deleteEmployee(employeeId);
	}
	
}
