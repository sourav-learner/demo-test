package com.example.demo;

public class DepartmentEmployeeCount {
	
    private String departmentName;
    private Long employeeCount;

    // Default constructor (required by some JSON converters)
    public DepartmentEmployeeCount() {}

    // Constructor with parameters
    public DepartmentEmployeeCount(String departmentName, Long employeeCount) {
        this.departmentName = departmentName;
        this.employeeCount = employeeCount;
    }

    // Getters and setters
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Long employeeCount) {
        this.employeeCount = employeeCount;
    }
}

