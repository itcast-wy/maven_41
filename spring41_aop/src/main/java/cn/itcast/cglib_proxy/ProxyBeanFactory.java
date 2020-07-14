package cn.itcast.cglib_proxy;

import cn.itcast.jdk_proxy.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBeanFactory {

    // 1 声明要代理的对象
    PersonService service = new PersonService();

    // 2.
    public ProxyBeanFactory(PersonService service1){
        service = service1;
    }

    // 3.
    public Object getProxy(){
        // cglib进行动态代理的核心类
        Enhancer enhancer = new Enhancer();
        // 设置要代理的类
        enhancer.setSuperclass(service.getClass());
        // 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * @param proxy      生成的代理对象
             * @param method    正在调用的方法
             * @param args      参数
             * @param methodProxy  方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                System.out.println("-------before-------");
                method.invoke(service);
                System.out.println("-------after-------");
                return null;
            }
        });

        // 创建代理对象
        return enhancer.create();
    }


}
