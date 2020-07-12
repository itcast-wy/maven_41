package cn.itcast.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserServiceTest {

    @Test
    public void play(){
        // 通过Spring来加载对象,不能直接new!!!

        // 1. 加载出Spring的Context对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 获取UserService
        UserService userService = (UserService) context.getBean("userService");
        // 3. 执行play方法
        userService.play();

    }


    @Test
    public void testUser01(){
        // 1. 加载出Spring的Context对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 获取User对象
        User user = (User) context.getBean("user");
        // 3. 打印
        System.out.println(user);
    }


    @Test
    public void testUser02(){
        // 1. 加载出Spring的Context对象
        ApplicationContext context = new FileSystemXmlApplicationContext("E:\\bigdata_ws3\\spring41_01\\src\\main\\resources\\applicationContext.xml");
        // 2. 获取User对象
        User user = (User) context.getBean("user");
        // 3. 打印
        System.out.println(user);
    }


    @Test
    public void testUser03(){
        // 1. 加载出Spring的Context对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 获取User对象, 根据class字节码对象,直接返回User,无需强制转换
        User user = context.getBean("user", User.class);
        // 3. 打印
        System.out.println(user);
    }

    @Test
    public void testUser04(){
        // 1. 加载出Spring的Context对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 获取User对象, 根据字节码对象去容器中查找并返回
        User user = context.getBean(User.class);
        // 3. 打印
        System.out.println(user);
    }


    @Test
    public void testUser05(){
        // 1. 加载出Spring的Context对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 获取User对象, 根据字节码对象去容器中查找并返回
        User user = context.getBean("user02",User.class);
        // ---------静态工厂对象没有交给Spring管理,所以这个地方会报错----------
//        StaticFactoryBean staticFactoryBean = context.getBean(StaticFactoryBean.class);
        // 3. 打印
        System.out.println(user);
//        System.out.println(staticFactoryBean);
    }

    @Test
    public void testUser06(){
        // 1. 加载出Spring的Context对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 获取User对象, 根据字节码对象去容器中查找并返回
        User user = context.getBean("user03",User.class);
        User user1 = context.getBean("user03",User.class);
        User user2 = context.getBean("user03",User.class);
        FactoryBean factoryBean = context.getBean(FactoryBean.class);
        // 3. 打印
        System.out.println(user);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(factoryBean);
    }


    /**
     * 测试单例/多例
     */
    @Test
    public void testUser07(){
        // 1. 加载出Spring的Context对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 获取User对象, 根据class字节码对象,直接返回User,无需强制转换
        User user = context.getBean("user04", User.class);
        User user1 = context.getBean("user04", User.class);
        User user2 = context.getBean("user04", User.class);
        User user3 = context.getBean("user04", User.class);
        // 3. 打印
        System.out.println("--------------打印user对象----------------------");
        System.out.println(user);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
    }
}
