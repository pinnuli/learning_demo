package com.pinnuli.spring.ioc.beanannotation.service;

import com.pinnuli.spring.base.UnitTestBase;
import com.pinnuli.spring.ioc.beanannotation.multibean.BeanInvoker;
import org.junit.Test;

import static org.junit.Assert.*;

public class InjectionServiceImplTest extends UnitTestBase {

    public InjectionServiceImplTest() {
        super("classpath:spring-beanannotation.xml");
    }

    @Test
    public void testAutowired() {
        InjectionService service = super.getBean("injectionServiceImpl");
        service.save("This is autowired.");
    }

    @Test
    public void testMultiBean(){
        BeanInvoker beanInvoker = super.getBean("beanInvoker");
        beanInvoker.say();
    }

}