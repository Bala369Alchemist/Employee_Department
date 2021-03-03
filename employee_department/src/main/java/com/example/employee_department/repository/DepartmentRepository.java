package com.example.employee_department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_department.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	Department findByDepartmentId(Integer departmentId);

	Department findByDepartmentName(String departmentName);

}
