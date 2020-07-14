package com.itheima.jdbcTemplate;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {




    @Test
    public void testInsert(){

        // 1. DrvierManagerDataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        // 2. JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        // 3. insert操作
        jdbcTemplate.update("INSERT INTO `stu` VALUES(?,?,?,?); ","2","王五","野鸡大学","300");
    }

}
