package com.example.employee_department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_department.entity.Department;
import com.example.employee_department.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public List<Department> getAlldepartment() {
		return departmentRepo.findAll();
	}

	@Override
	public Department findByDepartmentId(Integer departmentId) {
		return departmentRepo.findByDepartmentId(departmentId);
	}

	@Override
	public Department findByDepartmentName(String departmentName) {
		return departmentRepo.findByDepartmentName(departmentName);
	}

	@Override
	public Department addDepartment(Department department) {
		return departmentRepo.save(department);
	}

	@Override
	public Department updateDepartment(Integer departmentId, Department department) {
		Department currentDepartment = departmentRepo.findByDepartmentId(departmentId);
		currentDepartment.setDepartmentName(department.getDepartmentName());
		return departmentRepo.save(currentDepartment);
	}

	@Override
	public void deleteDepartment(Integer departmentId) {
		Department department = findByDepartmentId(departmentId);
		String departmentName = department.getDepartmentName();
		Integer employees = employeeService.numberOfEmployeeInDepartment(departmentName);
		
		if(employees==0) {
		departmentRepo.deleteById(departmentId);
		}else {
			System.out.println("Please remove employees from department before deleting");
		}
	}

}
