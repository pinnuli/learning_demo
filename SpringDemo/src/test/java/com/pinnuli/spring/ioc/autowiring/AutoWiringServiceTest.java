package com.pinnuli.spring.ioc.autowiring;

import com.pinnuli.spring.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class AutoWiringServiceTest extends UnitTestBase {

   public AutoWiringServiceTest(){
       super("classpath:spring-autowiring.xml");
   }

   @Test
    public void testSay(){
       AutoWiringService service = super.getBean("autoWiringService");
       service.say("this is a test");
   }
}