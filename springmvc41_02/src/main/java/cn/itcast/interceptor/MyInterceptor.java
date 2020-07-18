package cn.itcast.interceptor;

import cn.itcast.pojo.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * 拦截器开发: 需要实现HandlerInterceptor接口
 *
 * preHandle():返回true的时候就是放行,可以去请求后边的Handler
 * 返回false,就是拦截,就无法往后去执行了
 */
public class MyInterceptor implements HandlerInterceptor{
    /**
     * 在Handler执行之前调用,如果返回true,则往后继续执行,如果返回false,则直接拦截
     * @param httpServletRequest    用户请求的request,我们可以在preHandle的时候进行request的人为设置,例如添加一些参数
     * @param httpServletResponse
     * @param o                     我们要去操作的方法的描述信息,我们一般不修改
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("----MyInterceptor1- preHandle ---");
        return true;
    }

    /**
     * 执行Handler之后运行,我们可以在此修改响应的数据
     * @param httpServletRequest
     * @param httpServletResponse      响应用户的response,我们可以在Handler执行之后, 在postHandle方法中,添加返回给用户的参数
     * @param o                        我们要去操作的方法的描述信息,我们一般不修改
     * @param modelAndView             这个就是Handler执行完毕之后返回的modelAndView,我们也可以人为的修改数据
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("----MyInterceptor1- postHandle ---" + o );

        List<Item> list = new ArrayList<Item>();
        list.add(new Item(3,"挖土机",80,new Date(),"可以开"));
        list.add(new Item(4,"小米扫地机器人",3500,new Date(),"可以坐"));

        modelAndView.addObject("itemList",list);
    }

    /**
     * 当返回了ModelAndView之后运行,常用于一些收尾动作,例如异常的日志记录
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception     异常信息,我们可以进行收集
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("----MyInterceptor1- afterCompletion ---");
    }
}
