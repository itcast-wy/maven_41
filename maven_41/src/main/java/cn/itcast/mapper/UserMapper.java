package cn.itcast.mapper;

import cn.itcast.pojo.User;

public interface UserMapper {

    User findById(String id);
}
