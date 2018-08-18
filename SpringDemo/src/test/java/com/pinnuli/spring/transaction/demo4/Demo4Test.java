package com.pinnuli.spring.transaction.demo4;

import com.pinnuli.spring.transaction.demo4.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-transaction4.xml")
public class Demo4Test {


    @Resource(name="accountService")
    private AccountService accountService;

    @Test
    public void demo4(){
//        AccountService accountService = super.getBean("accountService");
        accountService.transfer("aaa", "bbb", 200d);
    }
}