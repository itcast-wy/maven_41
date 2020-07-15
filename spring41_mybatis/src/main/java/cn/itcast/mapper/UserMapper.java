package cn.itcast.mapper;

import cn.itcast.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

interface UserMapper {
    //1.根据id查询用户信息
    public User findUserById(int id);

    //2.根据name模糊查询用户信息
    public List<User> findUsersByName(String name);

    //3.添加用户信息
    public void addUser(User user);
}