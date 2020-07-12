package cn.itcast.annotation;


import org.springframework.stereotype.Repository;

/**
 * Dao层我们一般使用@Repository
 * @Repository("该对象的id值")
 */
@Repository
public class UserDaoImpl1 implements UserDao{
    @Override
    public void findUsers() {
        System.out.println("------UserDaoImpl1-----findUsers--");
    }
}
