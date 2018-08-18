package com.pinnuli.spring.ioc.bean;

import com.pinnuli.spring.base.UnitTestBase;
import org.junit.Test;
import org.junit.runners.Suite;

import static org.junit.Assert.*;

public class BeanScopeTest extends UnitTestBase {
    public BeanScopeTest(){
        super("classpath*:spring-beanscope.xml");
    }

    @Test
    public void testSay(){
        BeanScope beanScope = super.getBean("beanScope");
        beanScope.say();

        beanScope = super.getBean("beanScope");
        beanScope.say();
    }

    @Test
    public void testSay2(){
        BeanScope beanScope = super.getBean("beanScope");
        beanScope.say();

        //BeanScope beanScope1 = super.getBean("beanScope");
        //beanScope1.say();
    }

}