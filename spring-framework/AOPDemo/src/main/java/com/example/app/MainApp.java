package com.example.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.model.Employee;
import com.example.service.EmployeeService;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService service = ctx.getBean(EmployeeService.class);

        Employee e1 = new Employee("1", "Alice", "Developer");
        service.addEmployee(e1);

        Employee e2 = new Employee("2", "Bob", "Tester");
        service.addEmployee(e2);

        System.out.println("Employee 1: " + service.getEmployeeById("1"));
        System.out.println("Employee 2: " + service.getEmployeeById("2"));

        try {
            System.out.println("Try get non-existent:");
            service.getEmployeeById("99"); // will throw and be caught by aspect
        } catch (Exception ex) {
            System.out.println("Caught exception in main: " + ex.getMessage());
        }

        ctx.close();
    }
}
