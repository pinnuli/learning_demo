package com.pinnuli.spring.transaction.demo1;

import com.pinnuli.spring.base.UnitTestBase;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class Demo1Test extends UnitTestBase {

    /*@Resource(name="accountService")
    private AccountService accountService;*/

    public Demo1Test(){
       super("classpath:spring-transaction.xml");
    }

    @Test
    public void demo1(){
        AccountService accountService = super.getBean("accountService");
        accountService.transfer("aaa", "bbb", 200d);
    }
}