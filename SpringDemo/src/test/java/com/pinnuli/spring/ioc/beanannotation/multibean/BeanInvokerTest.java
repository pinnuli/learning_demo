package com.pinnuli.spring.ioc.beanannotation.multibean;

import com.pinnuli.spring.base.UnitTestBase;
import org.junit.Test;

public class BeanInvokerTest extends UnitTestBase {
    public BeanInvokerTest(){
        super("classpath:spring-beanannotation.xml");
    }

    @Test
    public void testMultiBean(){
        BeanInvoker beanInvoker = super.getBean("beanInvoker");
        beanInvoker.say();
    }

}