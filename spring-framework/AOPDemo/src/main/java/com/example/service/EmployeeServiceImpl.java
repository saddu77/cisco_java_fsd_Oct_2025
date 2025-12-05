package com.example.service;

import com.example.model.Employee;
import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> store = new HashMap<>();

    @Override
    public void addEmployee(Employee emp) {
        System.out.println("[Service] adding employee: " + emp);
        store.put(emp.getId(), emp);
    }

    @Override
    public Employee getEmployeeById(String id) {
        System.out.println("[Service] fetching employee by id: " + id);
        Employee e = store.get(id);
        if (e == null) throw new NoSuchElementException("Employee not found: " + id);
        return e;
    }

    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("[Service] fetching all employees");
        return new ArrayList<>(store.values());
    }

    @Override
    public void updateEmployee(Employee emp) {
        System.out.println("[Service] updating employee: " + emp);
        if (!store.containsKey(emp.getId())) throw new NoSuchElementException("Employee not found: " + emp.getId());
        store.put(emp.getId(), emp);
    }

    @Override
    public void deleteEmployee(String id) {
        System.out.println("[Service] deleting employee: " + id);
        store.remove(id);
    }
}
