package cn.itcast.aop_xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean2.xml")
public class UserTest2 {

    @Autowired
    User user;

    @Autowired
    Advice advice;


    @Test
    public void testUser(){
        // 前置通知
//        user.addUser();
//        // 后置通知
//        user.deleteUser();
//        // 异常通知
//        user.updateUser();
        // 环绕通知
        user.queryUser();
        // 最终通知
//        user.batchDeleteUser();

    }


}
