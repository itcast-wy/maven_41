package cn.itcast.xml.service;


import cn.itcast.xml.dao.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    AccountService service;

    @Test
    public void transferIn(){
        service.transfer("aaa","bbb",200);
    }

}
