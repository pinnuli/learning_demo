package com.pinnuli.spring.ioc.interfaces;

import com.pinnuli.spring.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(BlockJUnit4ClassRunner.class)
public class OneInterfaceTest extends UnitTestBase{

    public OneInterfaceTest() {
        super("classpath*:spring-ioc.xml");
    }

    @Test
    public void say() throws Exception {
        OneInterface oneInterface = super.getBean("oneInterface");
        oneInterface.say("This is a test.");
    }

}