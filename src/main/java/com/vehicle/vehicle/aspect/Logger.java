package com.vehicle.vehicle.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Slf4j
@Component
public class Logger {
//    @Before("execution(public * *(..))")
    @Before("execution(public * com.vehicle.vehicle..*.*(..))")
    public void logger(JoinPoint joinPoint) {
        log.info("Entered {}", joinPoint.getSignature().getName());
    }

    @After("execution(public * com.vehicle.vehicle..*.*(..))")
    public void afterLogger(JoinPoint joinPoint) {
        log.info("Exited {}", joinPoint.getSignature().getName());
    }
}
