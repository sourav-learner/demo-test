package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	
	 @Autowired
	    private DepartmentRepository departmentRepository;

	    public List<Department> getAllDepartments() {
	        return departmentRepository.findAll();
	    }

	    public Department getDepartmentById(Long id) {
	        return departmentRepository.findById(id).orElse(null);
	    }

	    public Department createDepartment(Department department) {
	        return departmentRepository.save(department);
	    }

	    public Department updateDepartment(Long id, Department departmentDetails) {
	        Department department = departmentRepository.findById(id).orElse(null);

	        if (department != null) {
	            department.setName(departmentDetails.getName());
	            return departmentRepository.save(department);
	        }

	        return null;
	    }

	    public void deleteDepartment(Long id) {
	        departmentRepository.deleteById(id);
	    }
}
