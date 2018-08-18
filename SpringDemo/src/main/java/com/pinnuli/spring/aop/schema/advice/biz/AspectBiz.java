package com.pinnuli.spring.aop.schema.advice.biz;

/**
 * @author: pinnuli
 * @date: 18-7-31
 */

public class AspectBiz {

    public void biz() {
        System.out.println("AspectBiz biz.");
//        throw new RuntimeException();
    }

    public void init(String bizName, int times) {
        System.out.println("AspectBiz init : " + bizName + "   " + times);
    }


}
