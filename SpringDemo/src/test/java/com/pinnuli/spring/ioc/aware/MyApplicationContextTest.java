package com.pinnuli.spring.ioc.aware;

import com.pinnuli.spring.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;


public class MyApplicationContextTest extends UnitTestBase {

    public MyApplicationContextTest() {
        super("classpath*:spring-aware.xml");
    }

    /*@Test
    public void testMyApplicationContext(){
        System.out.println("testMyApplicationContext:" + super.getBean("myApplicationContext").hashCode());
    }*/

    @Test
    public void testMyBeanName(){
        System.out.println("testMyBeanName:" + super.getBean("myBeanName").hashCode());
    }

}