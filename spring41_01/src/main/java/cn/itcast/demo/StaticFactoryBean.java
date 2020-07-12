package cn.itcast.demo;

/**
 * 静态工厂
 */
public class StaticFactoryBean {

    public StaticFactoryBean() {
        System.out.println("---- StaticFactoryBean构造方法被调用 ---");
    }

    public static User getUser(){
        System.out.println("---------getUser()---------");
        return new User();
    }
}
