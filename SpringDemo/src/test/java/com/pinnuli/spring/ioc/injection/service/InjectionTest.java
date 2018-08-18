package com.pinnuli.spring.ioc.injection.service;

import com.pinnuli.spring.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class InjectionTest extends UnitTestBase {

    public InjectionTest() {
        super("classpath*:spring-injection.xml");
    }

    @Test
    public void testSetter() {
        InjectionService service = super.getBean("injectionService");
        service.save("这是要保存的数据");
    }


    /*@Test
    public void testCons() {
        InjectionService service = super.getBean("injectionService");
        service.save("这是要保存的数据");
    }*/
}