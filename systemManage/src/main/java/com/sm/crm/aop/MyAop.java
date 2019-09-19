package com.sm.crm.aop;

import com.sm.crm.entity.Log;
import com.sm.crm.entity.User;
import com.sm.crm.mapper.LogMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

/**
 * 记录日志相关
 */
@Aspect
@Component
public class MyAop {
    @Autowired
    LogMapper logMapper;

    @Pointcut(value = "execution(* com.sm.crm.controller.*.*(..))")
    private void method() {
    }

    @Around("method()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        String visitModel = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        HttpServletRequest request = null;
//        for (int i = 0; i < args.length; i++) {
//            if (args[i] instanceof HttpServletRequest) {
//                 request = (HttpServletRequest) args[i];
//            }
//        }
//        User user = (User) request.getSession().getAttribute("user");
//        String userName = user!=null?user.getUserName():
        Object proceed = joinPoint.proceed();
        String behaviour = "----";
        String userName = "赵四";
        String visitModel = joinPoint.getSignature().getName();
        Log log = new Log(userName, visitModel, new Date(), behaviour);
        logMapper.insertLog(log);
        return proceed;
    }

    @After(value = "method()&&args(request)")
    public void doAfter(HttpServletRequest request) {
        if (request != null) {
            User user = (User) request.getSession().getAttribute("user");
        }
    }
}
