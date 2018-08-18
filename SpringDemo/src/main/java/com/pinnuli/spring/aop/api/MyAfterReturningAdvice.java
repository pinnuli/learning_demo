package com.pinnuli.spring.aop.api;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author: pinnuli
 * @date: 18-8-16
 */

public class MyAfterReturningAdvice implements AfterReturningAdvice{


    @Override
    public void afterReturning(Object returnValue, Method method,
                               Object[] args, Object target) throws Throwable {
        System.out.println("MyAfterReturningAdvice : " + method.getName() + "     " +
                target.getClass().getName() + "       " + returnValue);
    }
}
