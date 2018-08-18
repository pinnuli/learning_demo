package com.pinnuli.spring.transaction.demo3;

import com.pinnuli.spring.transaction.demo3.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-transaction3.xml")
public class Demo3Test {


    @Resource(name="accountService")
    private AccountService accountService;

    @Test
    public void demo3(){
//        AccountService accountService = super.getBean("accountService");
        accountService.transfer("aaa", "bbb", 200d);
    }
}