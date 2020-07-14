package com.itheima.test;

import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao {

    public void testPerson() {
        System.out.println("测试用户..");
    }
}
