package com.itheima.jdbcTemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean3.xml")
public class JdbcTemplateDemo2 {

    // 2. JdbcTemplate
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert(){
        // 3. insert操作
        jdbcTemplate.update("INSERT INTO `stu` VALUES(?,?,?,?); ","3","王五","野鸡大学","300");
    }


    //    需求1: 修改第一条学生信息

    @Test
    public void testUpdate(){
        // 3. insert操作
        jdbcTemplate.update("update stu set sname=?,schoolName=?, score=? where sid=1;","赵小四","山东大学","400");
    }


    //    需求2: 删除第二条学生信息
    @Test
    public void testDelete(){
        // 3. insert操作
        jdbcTemplate.update("delete from stu where sid=?;","3");
    }
}
