package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.model.Employee;

@Aspect
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    // pointcut for all methods in service package
    @Pointcut("execution(* com.example.service.*.*(..))")
    public void serviceMethods() {}

    // BEFORE advice
    @Before("serviceMethods()")
    public void beforeServiceMethods(org.aspectj.lang.JoinPoint jp) {
        Signature sig = jp.getSignature();
        log.info("[Before] Entering: {} with args: {}", sig, jp.getArgs());
    }

    // AFTER RETURNING advice - captures return value when present
    @AfterReturning(pointcut = "serviceMethods()", returning = "retVal")
    public void afterReturningServiceMethods(org.aspectj.lang.JoinPoint jp, Object retVal) {
        log.info("[AfterReturning] {} returned: {}", jp.getSignature(), retVal);
    }

    // AFTER THROWING advice
    @AfterThrowing(pointcut = "serviceMethods()", throwing = "ex")
    public void afterThrowingServiceMethods(org.aspectj.lang.JoinPoint jp, Throwable ex) {
        log.error("[AfterThrowing] Exception in {}: {}", jp.getSignature(), ex.getMessage());
    }

    // AROUND advice example
    @Around("execution(* com.example.service.EmployeeService.getEmployeeById(..))")
    public Object aroundGetEmployee(ProceedingJoinPoint pjp) throws Throwable {
        log.info("[Around] Before getEmployeeById");
        long start = System.currentTimeMillis();
        try {
            Object result = pjp.proceed();
            long elapsed = System.currentTimeMillis() - start;
            log.info("[Around] After getEmployeeById (took {} ms)", elapsed);
            return result;
        } catch (Throwable t) {
            log.error("[Around] Exception in getEmployeeById: {}", t.getMessage());
            throw t;
        }
    }

    // Example: advise methods that accept Employee param, and read the name
    @Before("execution(* com.example.service.*.*(..)) && args(emp,..)")
    public void beforeMethodsWithEmployeeArg(Employee emp) {
        if (emp != null) {
            log.info("[Before Args] Employee name passed: {}", emp.getName());
        }
    }
}
