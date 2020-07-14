package com.itheima.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean2.xml")
public class PersonDaoTest {

    @Autowired
    PersonDao personDao;

    @Test
    public void testPerson_old(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        //2.获取对象
        PersonDaoImpl personDaoImpl = context.getBean("personDaoImpl", PersonDaoImpl.class);
        personDaoImpl.testPerson();
    }

    @Test
    public void testPerson(){
        personDao.testPerson();
    }
}
