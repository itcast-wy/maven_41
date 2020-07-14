package cn.itcast.aop_xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class UserTest {

    @Autowired
    User user;

    @Autowired
    UserImpl2 userImpl2;

    @Autowired
    Advice advice;


    @Test
    public void testUser(){
        user.work();
        userImpl2.work2();
        advice.work();
        // class com.sun.proxy.$Proxy13 user明显是动态生成的
        System.out.println(user.getClass());
        System.out.println(userImpl2.getClass());
        System.out.println(advice.getClass());
    }
}
