package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;
import com.example.aspect.LoggingAspect;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public EmployeeService employeeService() {
        return new EmployeeServiceImpl();
    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
