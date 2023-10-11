package com.example.demo;

import java.util.ArrayList;
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

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/get")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		return departmentService.getDepartmentById(id);
	}

	@PostMapping("/create")
	public Department createDepartment(@RequestBody Department department) {
		return departmentService.createDepartment(department);
	}

	@GetMapping("/employeeCount")
	public List<DepartmentEmployeeCount> getEmployeeCountByDepartment() {
		List<Department> departments = departmentService.getAllDepartments();
		List<DepartmentEmployeeCount> departmentCounts = new ArrayList<>();

		for (Department department : departments) {
			Long count = employeeService.getEmployeeCountByDepartment(department.getId());
			DepartmentEmployeeCount departmentCount = new DepartmentEmployeeCount(department.getName(), count);
			departmentCounts.add(departmentCount);
		}

		return departmentCounts;
	}

	@PutMapping("/{id}")
	public Department updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
		return departmentService.updateDepartment(id, departmentDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartment(id);
	}
}
