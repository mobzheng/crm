package com.sm.crm.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Component;

/**
 * 记录日志相关
 */
@Aspect
@Component
public class MyAop {

    @Pointcut("execution(* com.sm.crm.controller.*.*(..))")
    private void method(){}


    @Around("method()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getName();
        return joinPoint.proceed();
    }
}
