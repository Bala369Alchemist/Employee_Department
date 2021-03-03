package com.example.employee_department.service;

import java.util.List;

import com.example.employee_department.entity.Department;

public interface DepartmentService {

	List<Department> getAlldepartment();

	Department findByDepartmentId(Integer departmentId);

	Department findByDepartmentName(String departmentName);

	Department addDepartment(Department department);

	Department updateDepartment(Integer departmentId, Department department);

	void deleteDepartment(Integer departmentId);

}
