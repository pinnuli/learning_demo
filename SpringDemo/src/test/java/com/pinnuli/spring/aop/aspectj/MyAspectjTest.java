package com.pinnuli.spring.aop.aspectj;

import com.pinnuli.spring.aop.aspectj.biz.MyBiz;
import com.pinnuli.spring.aop.schema.advice.MyAspectTest;
import com.pinnuli.spring.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyAspectjTest extends UnitTestBase {

    public MyAspectjTest(){
        super("classpath:spring-aop-aspectj.xml");
    }

    @Test
    public void test() {
        MyBiz biz = getBean("myBiz");
        biz.save("This is test.");
    }
}