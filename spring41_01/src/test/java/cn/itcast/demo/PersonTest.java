package cn.itcast.demo;

import cn.itcast.di.Person;
import cn.itcast.life.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {

    @Test
    public void person01(){
        // 通过Spring来加载对象,不能直接new!!!
        // 1. 加载出Spring的Context对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean02.xml");

        // 2. 获取对象
        Person person = context.getBean("person", Person.class);

        // 3. 打印
        System.out.println(person);

    }

    @Test
    public void person02(){
        // 通过Spring来加载对象,不能直接new!!!
        // 1. 加载出Spring的Context对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean02.xml");

        // 2. 获取对象
        Person person = context.getBean("person02", Person.class);

        // 3. 打印
        System.out.println(person);

    }

    @Test
    public void person04(){
        // 通过Spring来加载对象,不能直接new!!!
        // 1. 加载出Spring的Context对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean03.xml");

        // 2. 获取对象
        Person person = context.getBean("person1", Person.class);

        // 3. 打印
        System.out.println(person);

    }

    @Test
    public void person05(){
        // 通过Spring来加载对象,不能直接new!!!
        // 1. 加载出Spring的Context对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean03.xml");

        // 2. 获取对象
        Person person = context.getBean("person2", Person.class);

        // 3. 打印
        System.out.println(person);

    }
}
