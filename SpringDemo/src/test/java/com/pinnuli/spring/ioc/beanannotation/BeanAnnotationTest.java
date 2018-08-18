package com.pinnuli.spring.ioc.beanannotation;

import com.pinnuli.spring.base.UnitTestBase;
import org.junit.Test;

public class BeanAnnotationTest extends UnitTestBase {

    public BeanAnnotationTest() {
        super("classpath:spring-beanannotation.xml");
    }

    @Test
    public void testSay() {
        BeanAnnotation bean = super.getBean("beanAnnotation");
        bean.say("This is test.");
    }


}