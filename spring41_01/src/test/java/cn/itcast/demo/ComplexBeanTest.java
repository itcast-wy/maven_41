package cn.itcast.demo;

import cn.itcast.di.ComplexBean;
import cn.itcast.di.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class ComplexBeanTest {

    @Test
    public void testComplexBean(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean03.xml");
        ComplexBean complexBean = context.getBean("complexBean", ComplexBean.class);
        String[] arr = complexBean.getArr();
        System.out.println(Arrays.toString(arr));
        System.out.println("---------------------");
        List<Person> list = complexBean.getList();
        for (Person person : list) {
            System.out.println(person);
        }

        System.out.println("---------------------");
        Set<String> set = complexBean.getSet();
        System.out.println(set);
        System.out.println("---------------------");

        Map<String, Person> map = complexBean.getMap();
        Set<Map.Entry<String, Person>> entrySet = map.entrySet();
        for (Map.Entry<String, Person> entry : entrySet) {
            System.out.println(entry.getKey()+ " "+ entry.getValue());
        }
        
        System.out.println("---------------------");
        Properties properties = complexBean.getProperties();
        System.out.println(properties);
    }
}