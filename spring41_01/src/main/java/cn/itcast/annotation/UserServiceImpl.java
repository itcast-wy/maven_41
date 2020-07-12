package cn.itcast.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 @Service
 @Controller
 @Repository
 @Component

 上述四个注解都可以实现Spring的自动扫描,效果完全一样
 为什么有4个注解呢:  只是为了方便大家通过注解就能区分出这个类是什么样式的类
                    是属于Controller还是Service还是Dao
                    如果想简单,全部都可以写成 @Component
 */
//@Controller
//@Repository
//@Component

@Service
public class UserServiceImpl implements UserService {

    /**
     *  @Autowired 是按照类型进行注入的,如果UserDao这个接口有两个实现类,就会报错
     *   @Qualifier("UserDaoImpl1") 通过名称注入
     */
    @Autowired
    @Qualifier("userDaoImpl1")
    UserDao userDao;

    /**
     *   @Resource(name="UserDaoImpl1") 通过名称查找对应的对象
     *   @Resource这是不是Spring的注解,这是Java提供的
     *   相当于@Autowired+@Qualifier("UserDaoImpl1")
     */
    @Resource(name="userDaoImpl1")
    UserDao userDao1;


    /**
     * 如果参数名和类上面的id值保持一致,那么也可以自动注入
     */
    @Autowired
    UserDao userDaoImpl1;

    @Value("柳岩")
    private String name;

    @Override
    public void findUsers() {
     // 调用 UserDao的findUsers方法
        userDao.findUsers();
        userDao1.findUsers();
        userDaoImpl1.findUsers();

        System.out.println(name);
    }
}
