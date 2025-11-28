package com.example.service;

import com.example.model.Employee;
import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee emp);
    Employee getEmployeeById(String id);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee emp);
    void deleteEmployee(String id);
}
