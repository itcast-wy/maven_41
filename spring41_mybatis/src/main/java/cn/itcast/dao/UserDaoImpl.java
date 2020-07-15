package cn.itcast.dao;

import cn.itcast.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * 整合之后,mybatis-spring整合包提供了一个父类,父类给我们给了一个获取SqlSession的方法
 * 只要继承父类.  SqlSessionDaoSupport 父类
 * 直接getSqlSession获取父类的SqlSession 不能直接使用.  看看父类中如何初始化sqlSession对象
 * 我们就在bean.xml中创建UserDaoImpl 对象,调用父类的setSqlSessionFactory,给他父类设置工厂对象
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
    @Override
    public User findUserById(int id) {
        // 从父类中获取sqlSession
        SqlSession sqlSession = getSqlSession();
        // 查询
        User user = sqlSession.selectOne("test.abc", id);
        //
        return user;
    }

    @Override
    public List<User> findUsersByName(String name) {
        // 从父类中获取sqlSession
        SqlSession sqlSession = getSqlSession();
        // 查询
        List<User> users = sqlSession.selectList("test.findUsersByName",name);
        //
        return users;
    }

    @Override
    public void addUser(User user) {
        // 从父类中获取sqlSession
        SqlSession sqlSession = getSqlSession();
        sqlSession.insert("test.addUser",user);
    }
}
