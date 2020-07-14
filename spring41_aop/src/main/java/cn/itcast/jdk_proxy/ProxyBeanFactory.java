package cn.itcast.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBeanFactory {

    // 声明出要代理的对象
    UserService userService;

    // 构造方法
    public ProxyBeanFactory(UserService userService){
        this.userService = userService;
    }

    public Object getProxyBean(){

        return Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),

                new InvocationHandler(){
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before==========="+method);
                        // 真实处理的方法
                        method.invoke(userService);
                        System.out.println("after===========");
                        return null;
                    }
                }
        );
    }
}
