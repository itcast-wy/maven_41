package cn.itcast.demo;

/**
 * 1: xml方式 <bean id="user" class="cn.itcast.demo.User"></bean>
 * 2: 注解方式 @Component
 */
public class User {

    public User() {
        System.out.println("无参构造方法被调用了.");
    }

}
