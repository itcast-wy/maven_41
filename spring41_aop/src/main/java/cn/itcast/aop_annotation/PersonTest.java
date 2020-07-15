package cn.itcast.aop_annotation;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean3.xml")
public class PersonTest {

    @Autowired
    Person person;

    @Test
    public void testUser(){
        // 前置通知
//        person.addPerson();
//        // 后置通知
//        person.deletePerson();
//        // 异常通知
//        person.updatePerson();
        // 环绕通知
//        person.queryPerson();
        // 最终通知
        person.batchDeletePerson();
    }

}
