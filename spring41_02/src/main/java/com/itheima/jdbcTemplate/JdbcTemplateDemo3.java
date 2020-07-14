package com.itheima.jdbcTemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean3.xml")
public class JdbcTemplateDemo3 {

    // 2. JdbcTemplate
    @Autowired
    JdbcTemplate jdbcTemplate;

    /*
        1. 根据根据id查询学生name
        2. 查询一共有多少个学生数
        3. 查询id为7 的student对象,返回Student
        4. 查询id为8的student对象返回map
        5. 查询所有的student对象 返回List<Map<String ,Object>>  queryForList
        6. 如果只想查询结果放到List<Bean>  query
     */

    // 根据根据id查询学生name
    @Test
    public void testFindById(){

        // 参数1: sql语句 参数2: 返回的结果的类型的字节码  参数3: 占位符设置的值
       String name = jdbcTemplate.queryForObject("SELECT sname from stu where sid=?",String.class,1);
       System.out.println(name);
    }


    // 查询一共有多少个学生数
    @Test
    public void testFindCount() {
        Integer count = jdbcTemplate.queryForObject("SELECT count(*) from stu", Integer.class);
        System.out.println(count);
    }


}
