package com.sm.crm.aop;

import com.sm.crm.entity.Log;
import com.sm.crm.entity.User;
import com.sm.crm.mapper.LogMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 记录日志相关
 */
@Aspect
@Component
public class MyAop {
    @Autowired
    LogMapper logMapper;

    @Pointcut("execution(* com.sm.crm.controller.*.*(..))")
    private void method(){}

    @Around("method()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        String visitModel = joinPoint.getSignature().getName();
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        User user = (User) servletRequestAttributes.getRequest().getSession().getAttribute("user");
        String userName = "赵四";
        Object proceed = joinPoint.proceed();
        String behaviour = "添加";
        Log log = new Log(userName, visitModel, new Date(), behaviour);
        logMapper.insertLog(log);
        return proceed;
    }
}
