package cn.itcast.annotation.service;

import cn.itcast.annotation.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Transactional : 放在类上边,则它的所有方法都开启了事务
@Transactional(isolation = Isolation.REPEATABLE_READ ,propagation = Propagation.REQUIRED ,timeout = -1)
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao dao;

    // 配置到方法上,只是该方法添加了事务
    @Transactional
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
