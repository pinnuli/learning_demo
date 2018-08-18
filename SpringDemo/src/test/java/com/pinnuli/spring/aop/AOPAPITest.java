package com.pinnuli.spring.aop;

import com.pinnuli.spring.aop.api.BizLogic;
import com.pinnuli.spring.base.UnitTestBase;
import org.junit.Test;

/**
 * @author: pinnuli
 * @date: 18-8-16
 */

public class AOPAPITest extends UnitTestBase{
    public AOPAPITest(){
        super("classpath:spring-aop-api.xml");
    }

    @Test
    public void testSave() {
        BizLogic logic = (BizLogic)super.getBean("bizLogicImpl");
        logic.save();
    }
}
