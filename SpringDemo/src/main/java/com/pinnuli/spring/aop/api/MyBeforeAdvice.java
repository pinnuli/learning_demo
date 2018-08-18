package com.pinnuli.spring.aop.api;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author: pinnuli
 * @date: 18-8-16
 */

public class MyBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        System.out.println("MyBeforeAdvice : " + method.getName() + "     " +
                target.getClass().getName());
    }
}
