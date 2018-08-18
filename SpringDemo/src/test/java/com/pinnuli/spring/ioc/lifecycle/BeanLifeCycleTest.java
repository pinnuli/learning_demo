package com.pinnuli.spring.ioc.lifecycle;

import com.pinnuli.spring.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeanLifeCycleTest extends UnitTestBase {
    public BeanLifeCycleTest(){
        super("classpath:spring-lifecycle.xml");
    }

    @Test
    public void test1(){
        super.getBean("beanLifeCycle");
    }

}