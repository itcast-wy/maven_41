package cn.itcast.xml.service;

import cn.itcast.xml.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao dao;

    @Override
    public void transfer(String inName, String outName, double money) {
        // 手动的开启事务...
        // 转出
        dao.transferOut(outName,money);
        // 人为制造异常
        // 出异常,手动回滚...
        int i = 1/0;
        // 转入
        dao.transferIn(inName,money);
        // 手动提交事务...
    }
}
