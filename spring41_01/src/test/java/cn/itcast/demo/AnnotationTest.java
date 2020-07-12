package cn.itcast.demo;

import cn.itcast.annotation.UserDaoImpl1;
import cn.itcast.annotation.UserServiceImpl;
import cn.itcast.di.ComplexBean;
import cn.itcast.di.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class AnnotationTest {

    @Test
    public void testDao(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("annotation.xml");

        UserDaoImpl1 userDaoImpl1 = context.getBean(UserDaoImpl1.class);
        userDaoImpl1.findUsers();
    }

    @Test
    public void testService(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("annotation.xml");

       UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        userService.findUsers();
    }
}