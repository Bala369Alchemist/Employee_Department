package com.example.employee_department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_department.entity.Department;
import com.example.employee_department.entity.Employee;
import com.example.employee_department.repository.DepartmentRepository;
import com.example.employee_department.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private DepartmentRepository departmentRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee findByEmployeeId(Integer employeeId) {
		return employeeRepo.findByEmployeeId(employeeId);
	}

	@Override
	public List<Employee> findByEmployeeName(String employeeName) {
		return employeeRepo.findAllByEmployeeName(employeeName);

	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Integer employeeId, Employee employee) {
		Employee currentEmployee = employeeRepo.findByEmployeeId(employeeId);
		currentEmployee.setEmployeeName(employee.getEmployeeName());
		currentEmployee.setAge(employee.getAge());
		currentEmployee.setDepartmentId(employee.getDepartmentId());
		return employeeRepo.save(currentEmployee);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		employeeRepo.deleteById(employeeId);

	}

	@Override
	public List<Employee> getAllEmployeesByDepartmentName(String departmentName) {
		Department department = departmentRepo.findByDepartmentName(departmentName);
		int departmentId = department.getDepartmentId();

		return employeeRepo.findAllEmployeeByDepartmentId(departmentId);
	}

	@Override
	public Integer numberOfEmployeeInDepartment(String departmentName) {
		List<Employee> employees = getAllEmployeesByDepartmentName(departmentName);
		return employees.size();

	}

}
