package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Long id, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id).orElse(null);

		if (employee != null) {
			employee.setName(employeeDetails.getName());
			employee.setDepartment(employeeDetails.getDepartment());
			return employeeRepository.save(employee);
		}

		return null;
	}

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

	public Long getEmployeeCountByDepartment(Long departmentId) {
		// TODO Auto-generated method stub
	    List<Employee> employees = employeeRepository.findByDepartmentId(departmentId);
	    return (long) employees.size();
	}
}
