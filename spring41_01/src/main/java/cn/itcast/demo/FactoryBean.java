package cn.itcast.demo;

/**
 * 实例工厂获取user对象
 */
public class FactoryBean {

    public FactoryBean(){
        System.out.println("-----------FactoryBean的构造方法-------------");
    }

    public User getUser(){
        return new User();
    }
}