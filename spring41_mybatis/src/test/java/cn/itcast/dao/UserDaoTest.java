package cn.itcast.dao;

import cn.itcast.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void findUserById(){
        User user = userDao.findUserById(2);
        System.out.println(user);
    }

    @Test
    public void findUsersByName(){
        List<User> users = userDao.findUsersByName("王");
        System.out.println(users);
    }

    @Test
    public void addUserTest() {
        User user = new User(0,"柳岩",new Date(),"2","北京");
        userDao.addUser(user);
    }


}
