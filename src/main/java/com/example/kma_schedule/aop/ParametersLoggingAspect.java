package com.example.kma_schedule.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ParametersLoggingAspect {

    @AfterReturning(value = "@annotation(LogMethodParameters)", returning = "result")
    public void logMethodReturningParameter(JoinPoint joinPoint, Object result)
    {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("METHOD " + signature.getMethod().getName() + " returning value: " + result);
    }

    @Before(value = "@annotation(LogMethodParameters)")
    public void logMethodParameters(JoinPoint joinPoint) {

        // Method Information
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("METHOD: " + signature.getMethod().getName());

        System.out.println("Method args names:");
        Arrays.stream(signature.getParameterNames())
                .forEach(s -> System.out.println("  arg name: " + s));

        System.out.println("Method args types:");
        Arrays.stream(signature.getParameterTypes())
                .forEach(s -> System.out.println("  arg type: " + s));

        System.out.println("Method args values:");
        Arrays.stream(joinPoint.getArgs())
                .forEach(o -> System.out.println("  arg value: " + o.toString()));

        System.out.println("Method returning type: " + signature.getReturnType());
    }
}
