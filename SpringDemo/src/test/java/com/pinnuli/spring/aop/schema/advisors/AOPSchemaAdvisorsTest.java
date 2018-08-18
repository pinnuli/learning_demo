package com.pinnuli.spring.aop.schema.advisors;

import com.pinnuli.spring.aop.schema.advisors.service.InvokeService;
import com.pinnuli.spring.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.stereotype.Service;

/**
 * @author: pinnuli
 * @date: 18-8-14
 */

@RunWith(BlockJUnit4ClassRunner.class)
public class AOPSchemaAdvisorsTest extends UnitTestBase{

    public AOPSchemaAdvisorsTest() {
        super("classpath:spring-aop-schema-advisors.xml");
    }

    @Test
    public void testSave() {
        InvokeService service = super.getBean("invokeService");
        service.invoke();

        System.out.println();
        service.invokeException();
    }
}
