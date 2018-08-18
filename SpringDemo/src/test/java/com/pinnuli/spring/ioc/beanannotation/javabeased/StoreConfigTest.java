package com.pinnuli.spring.ioc.beanannotation.javabeased;

import com.pinnuli.spring.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoreConfigTest extends UnitTestBase{
    public StoreConfigTest(){
        super("classpath:spring-beanannotation.xml");
    }

    @Test
    public void testBean(){
        Store store = super.getBean("store");
        System.out.println(store.getClass().getName());
    }

    @Test
    public void testMyDriverManager(){
        MyDriverManager myDriverManager = super.getBean("myDriverManager");
    }
}