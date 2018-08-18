package com.pinnuli.spring.aop.api;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author: pinnuli
 * @date: 18-8-16
 */

public class MyThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception ex) throws Throwable {
        System.out.println("MyThrowsAdvice afterThrowing 1");
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
        System.out.println("MyThrowsAdvice afterThrowing 2 : " + method.getName() + "       " +
                target.getClass().getName());
    }
}
