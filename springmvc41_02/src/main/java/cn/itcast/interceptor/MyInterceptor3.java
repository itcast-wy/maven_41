package cn.itcast.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 拦截器开发: 需要实现HandlerInterceptor接口
 *
 * preHandle():返回true的时候就是放行,可以去请求后边的Handler
 * 返回false,就是拦截,就无法往后去执行了
 */
public class MyInterceptor3 implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("----MyInterceptor3- preHandle ---");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("----MyInterceptor3- postHandle ---");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("----MyInterceptor3- afterCompletion ---");
    }
}
