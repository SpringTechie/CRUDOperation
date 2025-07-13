package com.springtechie.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ApiInterceptors implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("PreHandle");
        System.out.println(request.getRequestURL());
        System.out.println(request.getRequestURI());
        System.out.println(request.getContextPath());
        System.out.println(request.getPathInfo());
        System.out.println(request.getMethod());
        System.out.println(request.getHeaderNames());

        StringBuffer requestURL = request.getRequestURL();
        if (requestURL.toString().contains("all/products")) {
            Integer size = Integer.valueOf(request.getParameter("size"));
            return size >= 0;
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("PostHandle");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
