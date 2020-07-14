package cn.itcast.cglib_proxy;


import org.junit.Test;

public class PersonServiceTest {

    @Test
    public void testProxyMethod(){
        // 创建原始对象
        PersonService personService = new PersonService();
        // 创建代理工厂
        ProxyBeanFactory beanFactory = new ProxyBeanFactory(personService);
        // 工厂中加工对象
        PersonService proxy = (PersonService) beanFactory.getProxy();
        proxy.work();

    }
}
