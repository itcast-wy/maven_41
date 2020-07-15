package cn.itcast.xml.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class AccountDaoTest {

    @Autowired
    AccountDao dao;

    @Test
    public void transferIn(){
        dao.transferIn("aaa",200);
        dao.transferOut("bbb",200);
    }
}
