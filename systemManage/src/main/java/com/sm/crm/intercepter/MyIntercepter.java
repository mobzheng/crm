package com.sm.crm.intercepter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MyIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("utf-8");

        response.setContentType("application/json;charset=utf-8");
        System.out.println(request.getPathTranslated());
        System.out.println(request.getPathInfo());
        System.out.println(request.getQueryString());
        System.out.println(request.getAuthType());
        System.out.println(request.getContextPath());
        System.out.println(request.getRemoteUser());
        System.out.println(request.getRequestURL());
        System.out.println(request.getServletPath());
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
//        if (user == null) {
//            Map<String,Object> map = new HashMap<String,Object>();
//            map.put("message","未登录");
//            ObjectMapper objectMapper = new ObjectMapper();
//            String jsonStr = objectMapper.writeValueAsString(map);
//            response.getWriter().append(jsonStr);
//            return false;
//        }
        return true;
    }


}
