package com.sm.crm.intercepter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sm.crm.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
//        System.out.println(request.getRemoteAddr());
//        System.out.println(request.getRequestURL())
//
//        HttpSession session = request.getSession();
//        Object user = session.getAttribute("user");
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
