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

import com.example.employee_department.entity.Department;
import com.example.employee_department.service.DepartmentService;

@RestController
@RequestMapping(value = "/department")
public class DepartmentRestController {

	@Autowired
	private DepartmentService departmentService;

	// to get all departments (works fine)
	@GetMapping(value = "/getAllDepartments")
	List<Department> getAlldepartment() {
		return departmentService.getAlldepartment();
	}

	// to get department by id (works fine)
	@GetMapping(value = "/getDepartmentById/{departmentId}")
	Department findByDepartmentId(@PathVariable Integer departmentId) {
		return departmentService.findByDepartmentId(departmentId);
	}

	// to get department by name (works fine)
	@GetMapping(value = "/getDepartmentByName/{departmentName}")
	Department findByDepartmentName(@PathVariable String departmentName) {
		return departmentService.findByDepartmentName(departmentName);
	}

	
	// add department (works fine)
	@PostMapping(value = "/addDepartment") 
	Department addDepartment(@RequestBody Department department) {
		return departmentService.addDepartment(department);
	}

	// update existing department (works fine)
	@PutMapping(value = "/updateDepartment/{departmentId}")
	Department updateDepartment(@PathVariable Integer departmentId, @RequestBody Department department) {
		return departmentService.updateDepartment(departmentId, department);
	}

	// delete department (works fine)
	@DeleteMapping(value = "/deleteDepartment/{departmentId}")
	void deleteDepartment(@PathVariable Integer departmentId) {
		departmentService.deleteDepartment(departmentId);
	}

}
