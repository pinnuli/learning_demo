package com.pinnuli.spring.aop.schema.advice;

import com.pinnuli.spring.aop.schema.advice.biz.AspectBiz;
import com.pinnuli.spring.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyAspectTest extends UnitTestBase {

    public MyAspectTest(){
        super("classpath:spring-aop-schema-advice.xml");
    }

    @Test
    public void testBiz(){
        AspectBiz biz = super.getBean("aspectBiz");
        biz.biz();
    }

    @Test
    public void testInit() {
        AspectBiz biz = super.getBean("aspectBiz");
        biz.init("myService", 3);
    }

    @Test
    public void testFit() {
        Fit fit = (Fit)super.getBean("aspectBiz");
        fit.filter();
    }
}