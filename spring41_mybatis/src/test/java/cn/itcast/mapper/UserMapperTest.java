package cn.itcast.mapper;

import cn.itcast.dao.UserDao;
import cn.itcast.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mapper.xml")
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;


    @Test
    public void findUserById(){
        User user = userMapper.findUserById(2);
        System.out.println(user);
    }

    @Test
    public void findUsersByName(){
        List<User> users = userMapper.findUsersByName("王");
        System.out.println(users);
    }

    @Test
    public void addUserTest() {
        User user = new User(1,"柳岩2",new Date(),"2","北京");
        userMapper.addUser(user);
    }

}
