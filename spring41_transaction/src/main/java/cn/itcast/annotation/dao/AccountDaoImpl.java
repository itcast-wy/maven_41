package cn.itcast.annotation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void transferIn(String inName, double money) {
        jdbcTemplate.update("update account set money=money+? WHERE name=?;",money,inName);
    }

    @Override
    public void transferOut(String outName, double money) {
        jdbcTemplate.update("update account set money=money-? WHERE name=?;",money,outName);
    }
}
