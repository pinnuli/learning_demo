package com.pinnuli.spring.transaction.demo2;

import com.pinnuli.spring.base.UnitTestBase;
import com.pinnuli.spring.transaction.demo2.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-transaction2.xml")
public class Demo2Test {


    @Resource(name="accountServiceProxy")
    private AccountService accountService;

    @Test
    public void demo2(){
//        AccountService accountService = super.getBean("accountService");
        accountService.transfer("aaa", "bbb", 200d);
    }
}